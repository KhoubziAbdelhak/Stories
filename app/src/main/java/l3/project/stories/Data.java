package l3.project.stories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import l3.project.stories.storyContent.Scene;
import l3.project.stories.storyContent.Story;

public class Data {

    public static List<Story> list_stories = new ArrayList<Story>();
    public static List<Story> list_favorite = new ArrayList<Story>();
    public static List<Story> list_history = new ArrayList<Story>();

    static {
        list_stories.add(
                new Story("Story 1", R.drawable.storyimage1, new Scene[]{
                        new Scene("Scene 1", "This is a scene of the kid story that i should be a little tall so i can test if the thing is working i am just typing to make it a little long, so don\'t mind ma and keep working on your project i guess you are doing great i need to make it a little longer...", R.drawable.storyimage1),
                        new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                        new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                })
        );

        list_stories.add(
                new Story("Story 2", R.drawable.storyimage2, new Scene[]{
                        new Scene("Scene 1", "this is just a text context of the SECOND story scene", R.drawable.storyimage2),
                        new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                        new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                })
        );

        list_stories.add(
                new Story("Story 3",  R.drawable.storyimage3, new Scene[]{
                        new Scene("Scene 1", "this is just a text context of the THIRD story scene", R.drawable.storyimage3),
                        new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                        new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                })
        );


        list_stories.add(

                new Story("Story 4", R.drawable.storyimage1, new Scene[]{
                        new Scene("Scene 1", "this is just a text context of the fourth story scene", R.drawable.storyimage1),
                        new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                        new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                })
        );
        list_stories.add(

                new Story("Story 5", R.drawable.storyimage2, new Scene[]{
                        new Scene("Scene 1", "this is just a text context of the fifth story scene", R.drawable.storyimage2),
                        new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                        new Scene("Scene 1", "this is just a text context of a story scene", R.drawable.storyimage1),
                })
        );

    }
}
