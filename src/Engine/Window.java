package Engine;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
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
    }
}
