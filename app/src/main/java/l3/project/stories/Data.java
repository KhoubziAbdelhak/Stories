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
                new Story("The wolf and the lamp", R.drawable.the_wolf_and_the_lamp_cover, new Scene[]{
                        new Scene("Scene 1", """
                                The reason of the strongest is always the best :
                                We will show it presently.""", R.drawable.the_wolf_and_the_lamp_scene_1),
                        new Scene("Scene 2", """
                                A Lamb quenched his thirst
                                In the course of a pure wave.
                                A wolf comes fasting looking for adventure""", R.drawable.the_wolf_and_the_lamp_scene_2),
                        new Scene("Scene 3", """
                                And that hunger in these places attracted.
                                Who makes you so bold to disturb my drink?
                                Says this animal full of rage:
                                You will be punished for your temerity.""", R.drawable.the_wolf_and_the_lamp_scene_3),
                        new Scene("Scene 4", """
                                — Sire, replies the Lamb, may your Majesty
                                Don't get angry;
                                But rather than she considers
                                That I go quenching my thirst
                                In the current,
                                More than twenty paces below Her,
                                And that therefore, in no way,
                                I can not disturb her drink.""", R.drawable.the_wolf_and_the_lamp_scene_4),
                        new Scene("Scene 5", """
                                "You disturb her," resumed this cruel beast,
                                And I know that you badmouth me last year.
                                "How would I have done it if I hadn't been born?"
                                Said the Lamb, I'm still suckling my mother.
                                "If it's not you, then it's your brother."
                                — I have none.
                                "So it's one of yours:""", R.drawable.the_wolf_and_the_lamp_scene_5),
                        new Scene("Scene 6", """
                                Because you don't spare me much,
                                You, your shepherds and your dogs.
                                I have been told: I must take my revenge.
                                Over there, deep in the forest
                                The Wolf takes it, and then eats it,
                                Without any other form of trial.""", R.drawable.the_wolf_and_the_lamp_scene_6),
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
                new Story("Story 3", R.drawable.storyimage3, new Scene[]{
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
