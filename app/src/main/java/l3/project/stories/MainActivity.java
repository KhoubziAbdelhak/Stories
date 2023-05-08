package l3.project.stories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import l3.project.stories.databinding.ActivityMainBinding;
import l3.project.stories.pages.FavoriteFragment;
import l3.project.stories.pages.HomeFragment;
import l3.project.stories.pages.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            int selected = item.getItemId();

            if (selected == R.id.btn_home) {
                replaceFragment(new HomeFragment());
            } else if (selected == R.id.btn_favorite) {
                replaceFragment(new FavoriteFragment());
            } else if (selected == R.id.btn_settings) {
                replaceFragment(new SettingsFragment());
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

}