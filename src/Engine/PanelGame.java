package Engine;

import Entity.Player;
import Objects.Weapon.BulletAK47;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class PanelGame extends JComponent {
    private Key key;
    private BulletAK47 bulletAK47;
    private int width = 1280;
    private Player player;
    private Graphics2D g2;
    private int height = 720;
    private Thread thread;
    private boolean start = true;
    private BufferedImage image;

    private final int FPS = 60;
    private final int TARGET_TIME = 1000000000 / FPS;
    public static long deltaTime = 0;


    public PanelGame() {


    }

    public void start() {


        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        initObjectGame();
        while (start) {
            long startTime = System.nanoTime();
            initKeyboard();
            drawGame();
            player.changeLocation(10,2);
            System.out.println(player.getX());


            render();
            drawBackground();
            long time = System.nanoTime() - startTime;
            if (time < TARGET_TIME) {
                long sleep = (TARGET_TIME - time) / 1000000;
                deltaTime = sleep;
                sleep(sleep);
            }
            System.out.println("Delta-FPS = "+deltaTime);

        }


    }

    public void drawGame() {
        player.draw(g2);
        player.update();
        player.gravity();
        bulletAK47.draw(g2);
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
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_W) {

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
            }
        });
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

    }

    public void sleep(long speed) {
        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
