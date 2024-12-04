package Engine;

import javax.swing.*;

import Utils.Exceptions.GameObjectIsNull;

import java.awt.*;

public class Window extends JFrame {

    private static int width = 1280;
    private static int height = 720;
    private String title = "BKEngine";

    public Window() throws GameObjectIsNull {
        setTitle(title);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setVisible(true);
        PanelGame panelGame = new PanelGame();
       // setLayout(new BorderLayout());
        add(panelGame, BorderLayout.CENTER);
        try {
            Thread.sleep(125);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pack();
        Thread game_thread = new Thread(panelGame);
        game_thread.start();



        /*
        frame.setLayout(new BorderLayout());
frame.add(cc, BorderLayout.CENTER);
         */
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width,height);
    }

    public static int getWidthFrame() {
        return width;
    }

    public static int getHeightFrame() {
        return height;
    }

    public static void main(String[] args) throws GameObjectIsNull {
        new Window();


    }
}
