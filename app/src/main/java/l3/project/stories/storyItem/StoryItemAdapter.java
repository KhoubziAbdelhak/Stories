package l3.project.stories.storyItem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.health.ServiceHealthStats;
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

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import l3.project.stories.Data;
import l3.project.stories.R;
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
        return new ViewHolder(storyView);
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
            storyImage.setRenderEffect(RenderEffect.createBlurEffect(10, 10, Shader.TileMode.MIRROR));
        }
        // */

        TextView storyTitle = holder.storyTitle;
        storyTitle.setText(story.getTitle());

        List<Story> list_favorite = Data.list_stories.stream().filter(Story::isFavorite)
                .collect(Collectors.toList());


        if (list_favorite.contains(stories.get(holder.getAdapterPosition())))
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
                if (!Data.list_stories.stream().filter(s -> s.getId() == story.getId()).findFirst().get().isHistory()) {
                    Data.list_stories.stream().filter(s -> s.getId() == story.getId()).findFirst()
                            .ifPresent(s -> s.setHistory(true));
                    SharedPreferences sharedPreferences = itemView.getContext().getSharedPreferences("", itemView.getContext().MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    Gson gson = new Gson();
                    String json = gson.toJson(Data.list_stories);
                    editor.putString("stories_list", json);
                    editor.apply();
                }

                Intent intent = new Intent(itemView.getContext(), StoryContent.class);
                intent.putExtra("story_data", stories.get(getAdapterPosition()));
                itemView.getContext().startActivity(intent);
            });

            favorite_button.setOnClickListener(view -> {
                Story story = stories.get(getAdapterPosition());

                if (story.isFavorite()) {
                    Data.list_stories.stream().filter(s -> s.getId() == story.getId()).findFirst()
                            .ifPresent(s -> s.setFavorite(false));
                    favorite_button.setImageResource(R.drawable.icon_not_favorite);
                    valueChangeListener.onValueChange(Data.list_stories.stream().filter(Story::isFavorite)
                            .collect(Collectors.toList()));
                } else {
                    Data.list_stories.stream().filter(s -> s.getId() == story.getId()).findFirst()
                            .ifPresent(s -> s.setFavorite(true));
                    favorite_button.setImageResource(R.drawable.icon_favorite);
                }

                SharedPreferences sharedPreferences = itemView.getContext().getSharedPreferences("", itemView.getContext().MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();
                String json = gson.toJson(Data.list_stories);
                editor.putString("stories_list", json);
                editor.apply();
            });
        }

    }


    public void setValueChangeListener(ValueChangeListener valueChangeListener) {
        this.valueChangeListener = valueChangeListener;
    }


}

