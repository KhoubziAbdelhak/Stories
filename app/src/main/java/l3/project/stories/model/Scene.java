package l3.project.stories.model;

import java.io.Serializable;

public class Scene implements Serializable {
    private String scene_title;
    private String context;
    private int image;
    private int voice;

    public Scene(String scene_title, String context, int image) {
        this.scene_title = scene_title;
        this.context = context;
        this.image = image;
    }

    public Scene(String scene_title, String context, int image, int voice) {
        this.scene_title = scene_title;
        this.context = context;
        this.image = image;
        this.voice = voice;
    }

    public String getScene_title() {
        return scene_title;
    }

    public void setScene_title(String scene_title) {
        this.scene_title = scene_title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}
