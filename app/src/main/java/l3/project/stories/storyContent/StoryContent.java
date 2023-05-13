package l3.project.stories.storyContent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import l3.project.stories.R;

public class StoryContent extends AppCompatActivity {

    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_content);

        if (getIntent().getExtras() != null) {
            story = (Story) getIntent().getSerializableExtra("story_data");
        }


        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
        StoryAdapter storyAdapter = new StoryAdapter(this, story);


        viewPager2.setAdapter(storyAdapter);
    }
}