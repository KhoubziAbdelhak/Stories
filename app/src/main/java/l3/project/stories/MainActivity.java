package l3.project.stories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Story[] stories = {
            new Story("Story 1", "Description 1", R.drawable.storyimage1),
            new Story("Story 2", "Description 2", R.drawable.storyimage2),
            new Story("Story 3", "Description 3", R.drawable.storyimage3),
            new Story("Story 4", "Description 4", R.drawable.storyimage1),
            new Story("Story 5", "Description 5", R.drawable.storyimage2)
    };

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv_stories);
        StoryItemAdapter storyItemAdapter = new StoryItemAdapter(this, stories);
        listView.setAdapter(storyItemAdapter);

    }
}