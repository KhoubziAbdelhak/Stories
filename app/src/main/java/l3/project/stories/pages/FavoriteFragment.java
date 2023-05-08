package l3.project.stories.pages;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import l3.project.stories.Data;
import l3.project.stories.R;
import l3.project.stories.storyContent.Story;
import l3.project.stories.storyContent.StoryContent;
import l3.project.stories.storyItem.StoryFavoriteItemAdapter;
import l3.project.stories.storyItem.StoryItemAdapter;

public class FavoriteFragment extends Fragment {

    List<Story> stories = Data.list_favorite;

    ListView listView;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    public static FavoriteFragment newInstance() {
        FavoriteFragment fragment = new FavoriteFragment();
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
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.lv_favorite);
        StoryFavoriteItemAdapter storyFavoriteItemAdapter = new StoryFavoriteItemAdapter(getContext(), stories);
        listView.setAdapter(storyFavoriteItemAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), StoryContent.class);
                intent.putExtra("story_data", stories.get(position));
                startActivity(intent);
            }
        });
    }
}