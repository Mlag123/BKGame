package Engine.SceneSystem;

import Utils.Exceptions.SceneIsNotFound;
import Utils.Tags;

import java.util.ArrayList;

public class SceneManager implements IScene {

    private ArrayList<AbstractScene> sceneList = new ArrayList<>();

    public SceneManager() {

    }

    public void addScene(AbstractScene scene) {
        sceneList.add(scene);
    }

    public AbstractScene getScene(Tags sceneTag) throws SceneIsNotFound {
        for (AbstractScene abstractScene : sceneList) {
            Tags tag = abstractScene.getTags();
            if (tag.equals(sceneTag)) {
                return abstractScene;
            }
        }
       throw new SceneIsNotFound("Scene '"+sceneTag+"' is not found");
    }



    @Override
    public void draw() {

    }

    @Override
    public void create() {

    }
    public void showScene(){

    }
    public void hideScene(){

    }

    @Override
    public void destroy() {

    }

    @Override
    public void update() {

    }
}
