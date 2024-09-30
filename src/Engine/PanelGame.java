package Engine;

import Engine.Controls.CustomKeyListener;
import Entity.AbstractEntity;
import Entity.Player;
import Math.GameObjects.GameObjectIsNull;
import Objects.Plate;
import Math.GameObjects.AbstractObject;
import Objects.Wall;
import Sound.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PanelGame extends JComponent {
    public static ArrayList<AbstractObject> objectArrayList = new ArrayList<>();
    private Key key;
    //private BulletAK47 bulletAK47;
    private int width = Window.getWidthFrame();
    private int height = Window.getHeightFrame();
    private Player player;
    private Graphics2D g2;
    private boolean start = true;
    private BufferedImage image;
    private Ticker ticker = new Ticker(20);
    private Plate plate;
    private Wall wall;
    private Sound sound;
    private Graphics graphics;


    public PanelGame() {


    }

    public void start() throws GameObjectIsNull {


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
                //  sound.play();
            }
        }).start();


        ticker.addTickListener(new TickListener() {
            @Override
            public void onTick(float deltaTime) {
                //System.out.println(Utils.getMem());
                player.changeLocation(0, 0);
                plate.changeLocation(30, 340);
                wall.changeLocation(600, 200);
                player.setVisible(true);
                drawGame();
                render(getGraphics());
                drawBackground();
                //      System.out.println(player.getVector2D().getX());

            }
        });

        while (start) {
            //   updateDraw();
            ticker.update();
            //   System.out.println("Delta-FPS = "+deltaTime+" class:"+PanelGame.class.getName());

        }


    }

    public void drawGame() {
        player.update();
        player.gravity();
        player.draw(g2);
        player.ShowDebugText(g2);
        plate.draw(g2);
        wall.draw(g2);
        //  bulletAK47.draw(g2);
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
        key = new Key();
        requestFocus();
        addKeyListener(new CustomKeyListener(player));

    }

    public void initObjectGame() throws GameObjectIsNull {

        player = new Player();
        //  player.changeLocation(player.getX(), player.getY());
//bulletAK47 = new BulletAK47();
        //  bulletAK47.changeLocation(0, 0);
        plate = new Plate();
        wall = new Wall();
    }


}
