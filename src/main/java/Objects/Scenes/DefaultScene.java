package Objects.Scenes;

import Engine.Controls.KeyboardInput;
import Engine.SceneSystem.AbstractScene;
import Engine.Window;
import Entity.Player;
import Objects.GarsObject;
import Objects.Plate;
import Objects.Wall;
import Utils.Exceptions.GameObjectIsNull;
import Utils.Tags;
import Math.Time;


import java.awt.*;
import java.awt.event.KeyEvent;

public class DefaultScene extends AbstractScene {
    private Plate testPlate;
    private Player player;
    private Wall wall = null;
    private GarsObject garsObject;

    public DefaultScene(Tags tags) throws GameObjectIsNull {
        super(tags);
    }


    public void draw() {
        testPlate.draw();
        player.draw();
        garsObject.draw();
        wall.draw();

    }
    float totalTime = 0;

    @Override
    public void FixedUpdate() {
        Time.getInstance().update();
        player.update(Time.getDeltaTime());

        player.gravity();


        totalTime +=Time.getDeltaTime();
        float amplitude = 0.1f*10;
        float freq = 5f;



        garsObject.additionVector(0, amplitude*Math.sin(totalTime*freq));
        garsObject.setScale(amplitude*Math.sin(totalTime*freq));

        if (KeyboardInput.isKeyPressed(KeyEvent.VK_W)) {
            player.moveUP();
        }
        if (KeyboardInput.isKeyPressed(KeyEvent.VK_D)) {
            try {
                player.moveRight();
            } catch (GameObjectIsNull e) {
                throw new RuntimeException(e);
            }
        }
        if (KeyboardInput.isKeyPressed(KeyEvent.VK_A)) {
            try {
                player.moveLeft();
            } catch (GameObjectIsNull e) {
                throw new RuntimeException(e);
            }
        }
        if (KeyboardInput.isKeyPressed(KeyEvent.VK_S)) {
            try {
                player.moveDown();
            } catch (GameObjectIsNull e) {
                throw new RuntimeException(e);
            }
        }
        if(KeyboardInput.isKeyPressed(KeyEvent.VK_R)){
            garsObject.changeLocation(0,0);

        }

    }

    @Override
    public void update() {
        drawBackground(new Color(0x008EFB));
        draw();
        testPlate.changeLocation(0, 500);
        wall.changeLocation(450, 350);
        player.ShowDebugText(player.getGraphics2D());


        //   player.changeLocation(870,660);

    }

    @Override
    public void init() {
        garsObject = new GarsObject();
        wall = new Wall();
        testPlate = new Plate();
        garsObject.changeLocation(Window.getWidthFrame()/2-150,Window.getHeightFrame()/2);
        try {
            player = new Player();
        } catch (GameObjectIsNull e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }
}
