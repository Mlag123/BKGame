package Objects.Scenes;

import Engine.SceneSystem.AbstractScene;
import Objects.Plate;
import Utils.Exceptions.GameObjectIsNull;
import Utils.Tags;

import java.awt.*;

public class DefaultScene extends AbstractScene {
    private Plate testPlate;

    public DefaultScene(Tags tags) throws GameObjectIsNull {
        super(tags);
    }

    @Override
    public void draw() {
        testPlate.draw();
    }

    @Override
    public void updateObjects() {
        testPlate.changeLocation(20, 30);

        draw();
        drawBackground(new Color(0x008EFB));
    }

    @Override
    public void initObjects() {
        testPlate = new Plate();
    }
}
