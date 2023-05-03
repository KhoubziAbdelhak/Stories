package l3.project.stories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private Story story;
    private Context context;

    public StoryAdapter(Context context, Story story) {
        this.context = context;
        this.story = story;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        holder.images.setImageResource(story.getScenes()[position].image);
        holder.texts.setText(story.getScenes()[position].context);
    }

    @Override
    public int getItemCount() {
        return story.getScenes().length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView texts;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.scene_image);
            texts = itemView.findViewById(R.id.scene_text);
        }
    }
}
