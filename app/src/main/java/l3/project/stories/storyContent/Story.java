package l3.project.stories.storyContent;

import java.io.Serializable;

public class Story implements Serializable {
    private String title;
    private int image;
    private Scene[] scenes;


    public Story() {
    }

    public Story(String title, int image, Scene[] scenes) {
        this.title = title;
        this.image = image;
        this.scenes = scenes;
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

    public void setScenes(Scene[] scenes) {
        this.scenes = scenes;
    }

}
