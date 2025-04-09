package Objects.Scenes;

import Engine.Controls.CustomKeyListener;
import Engine.SceneSystem.AbstractScene;
import Entity.Player;
import Objects.Plate;
import Objects.Wall;
import Utils.Exceptions.GameObjectIsNull;
import Utils.Tags;

import java.awt.*;

public class DefaultScene extends AbstractScene {
    private Plate testPlate;
    private Player player;
    private CustomKeyListener customKeyListener = null;
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

    public void initKeyboard() {
        customKeyListener = new CustomKeyListener(this.player);
        Thread thread_keyboard = new Thread(customKeyListener);
        thread_keyboard.start();
    }


    public void update() {
        drawBackground(new Color(0x008EFB));
        draw();
        testPlate.changeLocation(0, 500);
        wall.changeLocation(450,350);


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
        initKeyboard();

    }

    public void start() {

    }

    public void destroy() {

    }
}
