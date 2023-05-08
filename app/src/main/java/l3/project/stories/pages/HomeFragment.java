package l3.project.stories.pages;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import l3.project.stories.Data;
import l3.project.stories.R;
import l3.project.stories.storyContent.Story;
import l3.project.stories.storyContent.StoryContent;
import l3.project.stories.storyItem.StoryItemAdapter;

public class HomeFragment extends Fragment {

    List<Story> stories = Data.list_stories;

    ListView listView;
    FloatingActionButton floatingActionButton;

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
        listView = view.findViewById(R.id.lv_stories);
        floatingActionButton = view.findViewById(R.id.set_favorite);
        StoryItemAdapter storyItemAdapter = new StoryItemAdapter(getContext(), stories);
        listView.setAdapter(storyItemAdapter);


    }
}