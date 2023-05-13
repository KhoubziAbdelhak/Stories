package l3.project.stories.storyItem;

import static androidx.viewpager.widget.PagerAdapter.POSITION_NONE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import l3.project.stories.Data;
import l3.project.stories.R;
import l3.project.stories.pages.HomeFragment;
import l3.project.stories.storyContent.Story;
import l3.project.stories.storyContent.StoryContent;

public class StoryItemAdapter extends RecyclerView.Adapter<StoryItemAdapter.ViewHolder> {

    private List<Story> stories;

    public StoryItemAdapter(List<Story> stories) {
        this.stories = stories;
    }

    public void onValueChange(List<Story> stories) {
        this.stories = stories;
    }

    public interface ValueChangeListener {
        void onValueChange(List<Story> stories);
    }

    private ValueChangeListener valueChangeListener;

    // Constructor and member variables
    @NonNull
    @Override
    public StoryItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View storyView = inflater.inflate(R.layout.activity_story_item, parent, false);

        // return new holder instance
        ViewHolder viewHolder = new ViewHolder(storyView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model base on the position
        Story story = stories.get(position);

        // Set item views based on your views and data model
        ImageView storyImage = holder.storyImage;
        storyImage.setImageResource(story.getImage());
        // /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            storyImage.setRenderEffect(RenderEffect.createBlurEffect(3, 3, Shader.TileMode.MIRROR));
        };
        // */

        TextView storyTitle = holder.storyTitle;
        storyTitle.setText(story.getTitle());

        if (Data.list_favorite.contains(stories.get(holder.getAdapterPosition())))
            holder.favorite_button.setImageResource(R.drawable.icon_favorite);
        else
            holder.favorite_button.setImageResource(R.drawable.icon_not_favorite);
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView storyImage;
        public TextView storyTitle;
        public CardView storyCard;
        public ImageButton favorite_button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            storyImage = (ImageView) itemView.findViewById(R.id.story_image);
            storyTitle = (TextView) itemView.findViewById(R.id.story_title);
            storyCard = (CardView) itemView.findViewById(R.id.story_card);
            favorite_button = (ImageButton) itemView.findViewById(R.id.set_favorite);


            storyCard.setOnClickListener(view -> {
                Story story = stories.get(getAdapterPosition());
                if (!Data.list_history.contains(story))
                    Data.list_history.add(story);

                Intent intent = new Intent(itemView.getContext(), StoryContent.class);
                intent.putExtra("story_data", stories.get(getAdapterPosition()));
                itemView.getContext().startActivity(intent);
            });

            favorite_button.setOnClickListener(view -> {
                Story story = stories.get(getAdapterPosition());
                if (Data.list_favorite.contains(story)) {
                    Data.list_favorite.remove(story);
                    favorite_button.setImageResource(R.drawable.icon_not_favorite);
                } else {
                    Data.list_favorite.add(story);
                    favorite_button.setImageResource(R.drawable.icon_favorite);
                }
                if (Data.list_favorite.equals(stories))
                    valueChangeListener.onValueChange(stories);
            });
        }

    }


    public void setValueChangeListener(ValueChangeListener valueChangeListener) {
        this.valueChangeListener = valueChangeListener;
    }
}

