package l3.project.stories.storyContent;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import l3.project.stories.R;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private final Story story;
    private final Context context;
    MediaPlayer player;

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
        holder.scene_image.setImageResource(story.getScenes()[position].image);
        holder.scene_text.setText(story.getScenes()[position].context);
        holder.play.setOnClickListener(StoryAdapter.this::play);
        holder.pause.setOnClickListener(StoryAdapter.this::pause);
        holder.stop.setOnClickListener(StoryAdapter.this::stop);
    }

    @Override
    public int getItemCount() {
        return story.getScenes().length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView scene_image;
        TextView scene_text;
        ImageButton play, pause, stop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            scene_image = itemView.findViewById(R.id.scene_image);
            scene_text = itemView.findViewById(R.id.scene_text);
            play = itemView.findViewById(R.id.play);
            pause = itemView.findViewById(R.id.pause);
            stop = itemView.findViewById(R.id.stop);
        }
    }

    public void play(View v) {
        if (player == null) {
            player = MediaPlayer.create(context, R.raw.the_wolf_and_the_lamp_1);
            player.setOnCompletionListener(mp -> stopPlayer());
        }
        player.start();
    }

    public void pause(View v) {
        if (player != null)
            player.pause();
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        stopPlayer();
    }
}
