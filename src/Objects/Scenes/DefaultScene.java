package Objects.Scenes;

import Engine.SceneSystem.AbstractScene;
import Utils.Exceptions.GameObjectIsNull;
import Utils.Tags;

public class DefaultScene extends AbstractScene {
    public DefaultScene(Tags tags) throws GameObjectIsNull {
        super(tags);
    }


    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void update() {

    }
}
