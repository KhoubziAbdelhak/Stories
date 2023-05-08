package l3.project.stories.storyItem;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import l3.project.stories.Data;
import l3.project.stories.R;
import l3.project.stories.storyContent.Story;
import l3.project.stories.storyContent.StoryContent;

public class StoryItemAdapter extends BaseAdapter {

    Context context;
    List<Story> stories;
    LayoutInflater inflater;

    public StoryItemAdapter(Context context, List<Story> stories) {
        this.context = context;
        this.stories = stories;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return stories.size();
    }

    @Override
    public Object getItem(int position) {
        return stories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_story_item, null);
        CardView cardView = (CardView) convertView.findViewById(R.id.story_card);
        FloatingActionButton floatingActionButton = (FloatingActionButton) convertView.findViewById(R.id.set_favorite);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.story_image);
        TextView title = (TextView) convertView.findViewById(R.id.story_title);
        TextView description = (TextView) convertView.findViewById(R.id.story_description);
        imageView.setImageResource(stories.get(position).getImage());
        title.setText(stories.get(position).getTitle());
        description.setText(stories.get(position).getDescription());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StoryContent.class);
                intent.putExtra("story_data", stories.get(position));
                context.startActivity(intent);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }
}
