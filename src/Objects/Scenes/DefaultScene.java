package Objects.Scenes;

import Engine.PanelGame;
import Engine.SceneSystem.AbstractScene;
import Entity.Player;
import Objects.Plate;
import Utils.Exceptions.GameObjectIsNull;
import Utils.Tags;

import java.awt.*;
import java.nio.Buffer;

public class DefaultScene extends AbstractScene {
    private Plate testPlate;
    private Player player;

    public DefaultScene(Tags tags) throws GameObjectIsNull {
        super(tags);
    }

    @Override
    public void draw() {
        testPlate.draw();
        player.draw();
    }

    @Override
    public void updateObjects() {

        testPlate.changeLocation(20, 80);
        player.changeLocation(30,30);
        draw();
        drawBackground(new Color(0x008EFB));

    }

    @Override
    public void initObjects() {
        testPlate = new Plate();
        try {
            player = new Player();
        } catch (GameObjectIsNull e) {
            throw new RuntimeException(e);
        }

    }
}
