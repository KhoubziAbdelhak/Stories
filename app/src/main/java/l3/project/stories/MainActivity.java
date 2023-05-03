package l3.project.stories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
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

    ListView listView;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv_stories);
        StoryItemAdapter storyItemAdapter = new StoryItemAdapter(this, stories);
        listView.setAdapter(storyItemAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Story_Content.class);
                intent.putExtra("story_data", stories[position]);
                startActivity(intent);
            }
        });

    }
}