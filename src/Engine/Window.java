package Engine;

import javax.swing.*;

import Math.Vector2D;

public class Window extends JFrame {

    public Window() {
        setTitle("BoyKisser Game");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setVisible(true);
        PanelGame panelGame = new PanelGame();
        add(panelGame);
        panelGame.start();
    }

    public static void main(String[] args) {
        new Window();

      //  Vector2D vec1 = new Vector2D(7, 4);
      //  Vector2D vec2 = Vector2D.normalVector2D(vec1);


      //  System.out.println(vec2.getX()+" "+vec2.getY());
    }
}
