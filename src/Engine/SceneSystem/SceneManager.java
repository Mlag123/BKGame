package Engine.SceneSystem;

import Engine.PanelGame;
import Utils.Exceptions.SceneIsNotFound;
import Utils.Tags;

import java.awt.*;
import java.util.ArrayList;

public class SceneManager implements IScene {

    private ArrayList<AbstractScene> sceneList = new ArrayList<>();
    private boolean isEnable = true;
    private Graphics2D g2 = PanelGame.g2;
    private Graphics g;

    public SceneManager() {
        this.g2 = g2;
        this.g = g;
    }

    public void sceneIsVisible(boolean isEnable) {
        this.isEnable = isEnable;
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
        throw new SceneIsNotFound("Scene '" + sceneTag + "' is not found");
    }

    public void renderScene(Tags tag) throws Exception {
     if(g2 != null){
         for (AbstractScene _scene : sceneList) {

             if (_scene.getTags().equals(tag)) {
                 _scene.initObjects();

                 while (isEnable) {
                     _scene.updateObjects();
                 }
             }else {
                 throw new SceneIsNotFound("Scene "+tag+" is not found");
             }

         }
     }else {
         throw new Exception("g2 is null");
     }
    }

/*    public AbstractScene getScene(Tags tag){
        for(AbstractScene _scene :sceneList){
            if(_scene.getTags().equals(tag)){
                return _scene;
            }
        }
    }*/

    @Override
    public void draw() {

    }

    @Override
    public void create() {

    }

    public void showScene() {

    }

    public void hideScene() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void update() {

    }
}
