package l3.project.stories.story_content;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import l3.project.stories.R;
import l3.project.stories.model.Story;

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
        holder.scene_image.setImageResource(story.getScenes()[position].getImage());
        holder.scene_text.setText(story.getScenes()[position].getContext());

        if (!story.hasVoice()) {
            holder.scene_buttons.setVisibility(View.GONE);
        } else {
            holder.scene_buttons.setVisibility(View.VISIBLE);
            holder.play.setOnClickListener(v -> play(position));
            holder.pause.setOnClickListener(v -> pause());
            holder.stop.setOnClickListener(v -> stop());
        }

    }

    @Override
    public int getItemCount() {
        return story.getScenes().length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView scene_image;
        TextView scene_text;
        LinearLayout scene_buttons;
        ImageButton play, pause, stop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            scene_image = itemView.findViewById(R.id.scene_image);
            scene_text = itemView.findViewById(R.id.scene_text);
            scene_buttons = itemView.findViewById(R.id.scene_buttons);
            play = itemView.findViewById(R.id.play);
            pause = itemView.findViewById(R.id.pause);
            stop = itemView.findViewById(R.id.stop);
        }
    }

    public void play(int position) {
        if (player == null) {
            player = MediaPlayer.create(context, story.getScenes()[position].getVoice());
            player.setOnCompletionListener(mp -> stopPlayer());
        }
        player.start();
    }

    public void pause() {
        if (player != null)
            player.pause();
    }

    public void stop() {
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
