package Engine;

import javax.swing.*;

import Math.Vector2D;

import java.awt.*;

public class Window extends JFrame {

    private static int width = 1280;
    private static int height = 720;

    public Window() {
        setTitle("BoyKisser Game");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setVisible(true);
        PanelGame panelGame = new PanelGame();
        add(panelGame);
        panelGame.start();
    }

    public static int getWidthFrame() {
        return width;
    }

    public static int getHeightFrame() {
        return height;
    }

    public static void main(String[] args) {
           new Window();


    }
}
