package l3.project.stories.storyItem;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import l3.project.stories.R;
import l3.project.stories.storyContent.Story;

public class StoryItemAdapter extends BaseAdapter {

    Context context;
    Story[] stories;
    LayoutInflater inflater;

    public StoryItemAdapter(Context context, Story[] stories) {
        this.context = context;
        this.stories = stories;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return stories.length;
    }

    @Override
    public Object getItem(int position) {
        return stories[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_story_item, null);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.story_image);
        TextView title = (TextView) convertView.findViewById(R.id.story_title);
        TextView description = (TextView) convertView.findViewById(R.id.story_description);
        imageView.setImageResource(stories[position].getImage());
        title.setText(stories[position].getTitle());
        description.setText(stories[position].getDescription());
        return convertView;
    }
}
