package l3.project.stories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class Story_Content extends AppCompatActivity {
    private ViewPager2 viewPager2;

    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_content);

        if(getIntent().getExtras() != null) {
             story = (Story) getIntent().getSerializableExtra("story_data");
        }


        viewPager2 = findViewById(R.id.viewPager2);
        StoryAdapter storyAdapter = new StoryAdapter(this, story);


        viewPager2.setAdapter(storyAdapter);
/*
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            // This method is triggered when there is any scrolling activity for the current page
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            // triggered when you select a new page
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            // triggered when there is
            // scroll state will be changed
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
*/
    }
}