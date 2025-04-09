package Engine;

import Engine.Core.ResourceLoader;
import Engine.SceneSystem.SceneManager;
import Objects.Scenes.DefaultScene;
import Objects.TextManager.Texts.SimpleText;
import Objects.TextManager.TextManager;
import Entity.Player;
import LuaLoader.ModLoader.LoadModFolder;
import Utils.Exceptions.GameObjectIsNull;
import Objects.Plate;
import Math.GameObjects.AbstractObject;
import Objects.Wall;
import Sound.Sound;
import Utils.Exceptions.SceneIsNotFound;
import Utils.Utils;
import logging.Logging;
import Utils.Tags;
import Math.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PanelGame extends JComponent implements Runnable {
    public static ArrayList<AbstractObject> objectArrayList = new ArrayList<>();
    private Key key;
    //private BulletAK47 bulletAK47;
    private int width = Window.getWidthFrame();
    private int height = Window.getHeightFrame();
    public static Player player;
    public static Graphics2D g2;
    private boolean start = true;
    private BufferedImage image;
    private Ticker ticker = new Ticker(20);
    private Plate plate;
    private Wall wall;
    public static Sound sound;
    //private Graphics graphics;
    private LoadModFolder loadModFolder;
    private TextManager textManager;
    private SimpleText simpleText; //this a debug text;
    private SimpleText textPlayerCoordinate;
    private SceneManager sceneManager;

    //  private TextManager fps_monitor;


    public PanelGame() {
        Logging.log("Loading mod");
        Logging.log("Created Example mod");
        loadModFolder = new LoadModFolder();
        Logging.log("Mods load.");

    }

    public void start() throws GameObjectIsNull {
        //FIXME TEST CODE!!

        //creating G2!!!
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      //   graphics = getGraphics();

        //scene manager.
        sceneManager = new SceneManager();


        //creating default scene.
        sceneManager.addScene(new DefaultScene(Tags.defaultScene));

        initKeyboard(); //init keyboard fixme!!!

        sceneManager.initScene(Tags.defaultScene); //trying rendering scene, if default scene is not equil null, called SceneIsNotFound exception


        new Thread(new Runnable() { //open new thread, running sound. Maybe deprecated code.
            @Override
            public void run() {
                sound = new Sound();
                sound.setFile(ResourceLoader.testMusic);

            }
        }).start();



       GameTicker ticker1 = new GameTicker(20, ()->{
           try {
               sceneManager.renderScene(Tags.defaultScene);

           } catch (SceneIsNotFound e) {

           } catch (Exception e) {
           }
           render(getGraphics());
       });
       ticker1.start();
       /* ticker.addTickListener(new TickListener() { //fixme, ticker. the game loop.
            @Override
            public void onTick(float deltaTime) {


                try {
                    sceneManager.renderScene(Tags.defaultScene);

                } catch (SceneIsNotFound e) {

                } catch (Exception e) {
                }
   *//*             //System.out.println(Utils.getMem());
                player.changeLocation(0, 0);
                plate.changeLocation(30, 420);
                wall.changeLocation(250, 300);
                player.setVisible(true);

                drawGame();


                render(getGraphics());
*//*
               // drawBackground();

                render(getGraphics());

            }

        });

        while (start) {
            //   updateDraw();
            ticker.update(); //fixme! this code update ticker.


        */


    }


    public void drawGame() { //this method calling from game loop, for update coordinate,sprite,and math function.
        player.update();
        player.gravity();
        player.draw();
        player.ShowDebugText(g2);
        plate.draw();
        wall.draw();
        simpleText.setText(Utils.getMem());
        String pl = "Player X :" + player.object_vector.x + "| Player Y :" + player.object_vector.y; //fixme debug
        textPlayerCoordinate.setText(new StringBuffer(pl));
        textManager.drawText();
    }


    public void drawBackground() {

        g2.setColor(new Color(0x008EFB));
        g2.fillRect(0, 0, width, height);
    }

    public void render(Graphics graphics) { //for render game. Maybe deprecated
        Graphics g = graphics;
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }

    public void initKeyboard() { //func for init keyboard.
    /*  key = new Key(); fixme
        requestFocus();
        addKeyListener(new CustomKeyListener(player));*/


    }

    public void initObjectGame() throws GameObjectIsNull { //init objects.

        player = new Player();
        //  player.changeLocation(player.getX(), player.getY());
//bulletAK47 = new BulletAK47();
        //  bulletAK47.changeLocation(0, 0);
        plate = new Plate();
        wall = new Wall();
        textManager = new TextManager();
        simpleText = new SimpleText(Color.red, Tags.debug, new Vector2D(20, 50), new Vector2D(0, 0));
        textPlayerCoordinate = new SimpleText(Color.ORANGE, Tags.debugPlayer, new Vector2D(20, 120), new Vector2D(0, 0));
        textManager.addSimpleText(simpleText);
        textManager.addSimpleText(textPlayerCoordinate);
        textManager.removeSimpleText(simpleText);


    }


    @Override
    public void run() { //For start game loop.
        try {
            start();
        } catch (GameObjectIsNull e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated //this func deprecated. Is not using in the future.
    public static Graphics2D getG2() {
        return g2;
    }
}
