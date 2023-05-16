package l3.project.stories.storyContent;

import java.io.Serializable;

public class Story implements Serializable {
    private int id;
    private String title;
    private int image;
    private Scene[] scenes;
    private boolean hasVoice = false;
    private boolean isFavorite = false;
    private boolean isHistory = false;


    public Story(int id, String title, int image, Scene[] scenes, boolean hasVoice, boolean isFavorite, boolean isHistory) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.scenes = scenes;
        this.hasVoice = hasVoice;
        this.isFavorite = isFavorite;
        this.isHistory = isHistory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Scene[] getScenes() {
        return scenes;
    }

    public boolean hasVoice() {
        return hasVoice;
    }

    public void setHasVoice(boolean hasVoice) {
        this.hasVoice = hasVoice;
    }

    public void setScenes(Scene[] scenes) {
        this.scenes = scenes;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public boolean isHistory() {
        return isHistory;
    }

    public void setHistory(boolean history) {
        isHistory = history;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
