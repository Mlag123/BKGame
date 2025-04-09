package Objects.Scenes;

import Engine.Controls.KeyboardInput;
import Engine.SceneSystem.AbstractScene;
import Entity.Player;
import Objects.Plate;
import Objects.Wall;
import Utils.Exceptions.GameObjectIsNull;
import Utils.Tags;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DefaultScene extends AbstractScene {
    private Plate testPlate;
    private Player player;
    private Wall wall = null;

    public DefaultScene(Tags tags) throws GameObjectIsNull {
        super(tags);
    }


    public void draw() {
        testPlate.draw();
        player.update();
        player.draw();
        player.gravity();
        wall.draw();

    }




    public void update() {
        drawBackground(new Color(0x008EFB));
        draw();
        testPlate.changeLocation(0, 500);
        wall.changeLocation(450,350);

        if (KeyboardInput.isKeyPressed(KeyEvent.VK_W)){
            player.moveUP();
        }
        if (KeyboardInput.isKeyPressed(KeyEvent.VK_D)){
            try {
                player.moveRight();
            } catch (GameObjectIsNull e) {
                throw new RuntimeException(e);
            }
        }
        if (KeyboardInput.isKeyPressed(KeyEvent.VK_A)){
            try {
                player.moveLeft();
            } catch (GameObjectIsNull e) {
                throw new RuntimeException(e);
            }
        }
        if (KeyboardInput.isKeyPressed(KeyEvent.VK_S)){
            try {
                player.moveDown();
            } catch (GameObjectIsNull e) {
                throw new RuntimeException(e);
            }
        }


        //   player.changeLocation(870,660);

    }

    public void init() {

        wall = new Wall();
        testPlate = new Plate();
        try {
            player = new Player();
        } catch (GameObjectIsNull e) {
            throw new RuntimeException(e);
        }

    }

    public void start() {

    }

    public void destroy() {

    }
}
