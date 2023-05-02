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

    private int[] images = {R.drawable.storyimage1, R.drawable.storyimage2, R.drawable.storyimage3};
    String scenes[] = {"some of the text for the first scene", "some of the text for the second", "and this is the final one"};
    private Context context;

    public StoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        holder.images.setImageResource(images[position]);
        holder.texts.setText(scenes[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView texts;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.images);
            texts = itemView.findViewById(R.id.texts);
        }
    }
}
