package l3.project.stories;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.Objects;

import l3.project.stories.storyContent.Scene;
import l3.project.stories.storyContent.Story;
import l3.project.stories.storyContent.StoryContent;
import l3.project.stories.storyItem.StoryItemAdapter;

public class HomeFragment extends Fragment {

    Story[] stories = {new Story("Story 1", "Description 1", R.drawable.storyimage1, new Scene[]{
            new Scene("Scene 1", "This is a scene of the kid story that i should be a little tall so i can test if the thing is working i am just typing to make it a little long, so don\'t mind ma and keep working on your project i guess you are doing great i need to make it a little longer...", R.drawable.storyimage1),
            new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
            new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
    }),
            new Story("Story 2", "Description 2", R.drawable.storyimage2, new Scene[]{
                    new Scene("Scene 1", "this is just a text context of the SECOND story scene", R.drawable.storyimage2),
                    new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                    new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
            }),
            new Story("Story 3", "Description 3", R.drawable.storyimage3, new Scene[]{
                    new Scene("Scene 1", "this is just a text context of the THIRD story scene", R.drawable.storyimage3),
                    new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                    new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
            }),
            new Story("Story 4", "Description 4", R.drawable.storyimage1, new Scene[]{
                    new Scene("Scene 1", "this is just a text context of the fourth story scene", R.drawable.storyimage1),
                    new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                    new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
            }),
            new Story("Story 5", "Description 5", R.drawable.storyimage2, new Scene[]{
                    new Scene("Scene 1", "this is just a text context of the fifth story scene", R.drawable.storyimage2),
                    new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                    new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
            }),
    };

    ConstraintLayout constraintLayout;
    ListView listView;
    Button button;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
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
        StoryItemAdapter storyItemAdapter = new StoryItemAdapter(getContext(), stories);
        listView.setAdapter(storyItemAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), StoryContent.class);
                intent.putExtra("story_data", stories[position]);
                startActivity(intent);
            }
        });
    }
}