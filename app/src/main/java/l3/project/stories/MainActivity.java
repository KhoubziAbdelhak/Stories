package l3.project.stories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.Arrays;

import l3.project.stories.databinding.ActivityMainBinding;
import l3.project.stories.pages.FavoriteFragment;
import l3.project.stories.pages.HomeFragment;
import l3.project.stories.pages.HistoryFragment;
import l3.project.stories.storyContent.Story;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            SharedPreferences sharedPreferences = getSharedPreferences("", MODE_PRIVATE);
            Gson gson = new Gson();
            String json = sharedPreferences.getString("stories_list", "");
            Story[] array_stories = gson.fromJson(json, Story[].class);
            Data.list_stories = Arrays.asList(array_stories);

        } catch (Exception e) {
            e.printStackTrace();
        }


        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            int selected = item.getItemId();

            if (selected == R.id.btn_home) {
                replaceFragment(new HomeFragment());
            } else if (selected == R.id.btn_favorite) {
                replaceFragment(new FavoriteFragment());
            } else if (selected == R.id.btn_history) {
                replaceFragment(new HistoryFragment());
            }

            return true;
        });
    }


    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences("", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Data.list_stories);
        editor.putString("stories_list", json);
        editor.apply();
    }
}