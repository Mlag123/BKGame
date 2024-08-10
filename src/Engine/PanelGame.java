package Engine;

import Engine.Controls.CustomKeyListener;
import Entity.AbstractEntity;
import Entity.Player;
import Objects.Plate;
import Objects.Weapon.AbstractObject;
import Objects.Weapon.BulletAK47;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PanelGame extends JComponent {
    public static ArrayList<AbstractObject> objectArrayList = new ArrayList<>();
    public static ArrayList<AbstractEntity> entityArrayList = new ArrayList<>();
    private Key key;
    private BulletAK47 bulletAK47;
    private int width = Window.getWidthFrame();
    private int height = Window.getHeightFrame();
    private Player player;
    private Graphics2D g2;
    private boolean start = true;
    private BufferedImage image;
    private Ticker ticker = new Ticker(20);
    private Plate plate;
    static String current_key = "stop";


    public PanelGame() {
    }

    public void start() {


        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        initObjectGame();
        initKeyboard();


        ticker.addTickListener(new TickListener() {
            @Override
            public void onTick(float deltaTime) {

                drawGame();
                // player.changeLocation(10,2);
                plate.changeLocation(0, 500);

                render();
                drawBackground();
            }
        });


        while (start) {
            //   updateDraw();

            ticker.update();

            //   System.out.println("Delta-FPS = "+deltaTime+" class:"+PanelGame.class.getName());

        }


    }

    public void drawGame() {
        player.gravity(plate);
        player.draw(g2);
        player.update();
        plate.draw(g2);
        bulletAK47.draw(g2);
    }

    public void updateDraw() {

    }

    public void drawBackground() {
        g2.setColor(new Color(0x008EFB));
        g2.fillRect(0, 0, width, height);
    }

    public void render() {
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }

    public void initKeyboard() {
        key = new Key();
        requestFocus();
        addKeyListener(new CustomKeyListener(player));


  /*      addKeyListener(new KeyAdapter() {
       *//*     @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }*//*

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_W) {
                    System.out.println("W");
                    key.setKey_up(true);
                    player.moveUP();

                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    key.setKey_down(true);
                    player.moveDown();


                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    key.setKey_left(true);
                    player.moveLeft();

                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    key.setKey_right(true);
                    player.moveRight();


                }

            }

*//*
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    key.setKey_up(false);


                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    key.setKey_down(false);


                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    key.setKey_left(false);

                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    key.setKey_right(false);


                }
            }*//*
        });*/
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                while (start) {
                    sleep(FPS / 10);
                    if (key.isKey_up()) {

                        player.moveUP();

                    } else if (key.isKey_down()) {
                        player.moveDown();
                        System.out.println(player.getY());
                    } else if (key.isKey_left()) {
                        player.moveLeft();
                    } else if (key.isKey_right()) {
                        player.moveRight();
                    }
                }
            }
        }).start();*/
    }

    public void initObjectGame() {

        player = new Player();
        //  player.changeLocation(player.getX(), player.getY());
        bulletAK47 = new BulletAK47();
        bulletAK47.changeLocation(0, 0);
        plate = new Plate();

    }


}
