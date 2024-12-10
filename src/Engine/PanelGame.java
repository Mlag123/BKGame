package Engine;

import Engine.Controls.CustomKeyListener;
import Objects.TextManager.Texts.SimpleText;
import Objects.TextManager.TextManager;
import Entity.Player;
import LuaLoader.ModLoader.LoadModFolder;
import Utils.Exceptions.GameObjectIsNull;
import Objects.Plate;
import Math.GameObjects.AbstractObject;
import Objects.Wall;
import Sound.Sound;
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
    private Sound sound;
    private Graphics graphics;
    private CustomKeyListener customKeyListener;
    private LoadModFolder loadModFolder;
    private TextManager textManager;
    private SimpleText simpleText; //this a debug text;
    private SimpleText textPlayerCoordinate;
    //  private TextManager fps_monitor;


    public PanelGame() {
        Logging.log("Loading mod");
        Logging.log("Created Example mod");
        loadModFolder = new LoadModFolder();
        Logging.log("Mods load.");

    }

    public void start() throws GameObjectIsNull {
        //FIXME TEST CODE!!

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics = getGraphics();


        initObjectGame();
        initKeyboard();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sound = new Sound();
                sound.setFile("./Resources/Sounds/main.wav");
                //   sound.play();
            }
        }).start();


        ticker.addTickListener(new TickListener() {
            @Override
            public void onTick(float deltaTime) {
                //System.out.println(Utils.getMem());
                player.changeLocation(0, 0);
                plate.changeLocation(30, 420);
                wall.changeLocation(250, 300);
                player.setVisible(true);

                drawGame();


                render(getGraphics());

                drawBackground();

            }

        });

        while (start) {
            //   updateDraw();
            ticker.update();


        }


    }


    public void drawGame() {
        player.update();
        player.gravity();
        player.draw();
        player.ShowDebugText(g2);
        plate.draw();
        wall.draw();
        simpleText.setText(Utils.getMem());
        String pl = "Player X :" + player.object_vector.x + "| Player Y :" + player.object_vector.y;
        textPlayerCoordinate.setText(new StringBuffer(pl));
        textManager.drawText();
    }


    public void drawBackground() {

        g2.setColor(new Color(0x008EFB));
        g2.fillRect(0, 0, width, height);
    }

    public void render(Graphics graphics) {
        Graphics g = graphics;
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }

    public void initKeyboard() {
    /*  key = new Key(); fixme
        requestFocus();
        addKeyListener(new CustomKeyListener(player));*/
        customKeyListener = new CustomKeyListener(player);
        Thread thread_keyboard = new Thread(customKeyListener);
        thread_keyboard.start();

    }

    public void initObjectGame() throws GameObjectIsNull {

        player = new Player();
        //  player.changeLocation(player.getX(), player.getY());
//bulletAK47 = new BulletAK47();
        //  bulletAK47.changeLocation(0, 0);
        plate = new Plate();
        wall = new Wall();
        textManager = new TextManager();
        simpleText = new SimpleText(Color.red, Tags.text, new Vector2D(20,50),new Vector2D(0,0));
        textPlayerCoordinate = new SimpleText(Color.ORANGE, Tags.text, new Vector2D(20,120),new Vector2D(0,0));
        textManager.addSimpleText(simpleText);
        textManager.addSimpleText(textPlayerCoordinate);


    }


    @Override
    public void run() {
        try {
            start();
        } catch (GameObjectIsNull e) {
            throw new RuntimeException(e);
        }
    }

    public static Graphics2D getG2(){
        return g2;
    }
}
