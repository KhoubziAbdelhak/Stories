package l3.project.stories.pages;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.List;

import l3.project.stories.Data;
import l3.project.stories.MainActivity;
import l3.project.stories.R;
import l3.project.stories.storyContent.Story;
import l3.project.stories.storyItem.StoryItemAdapter;

public class HomeFragment extends Fragment {

    List<Story> stories = Data.list_stories;

    // ListView listView;
    RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_stories);
        StoryItemAdapter storyItemAdapter = new StoryItemAdapter(stories, this);

        storyItemAdapter.setValueChangeListener(
                stories -> {
                    storyItemAdapter.onValueChange(stories);
                    recyclerView.setAdapter(storyItemAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                });

        recyclerView.setAdapter(storyItemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

}