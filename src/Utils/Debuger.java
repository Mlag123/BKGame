package Utils;

import javax.swing.*;

public class Debuger extends JFrame {

    private JFrame frame = new JFrame();
    private boolean isDev = true;
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();



    public Debuger() {
        super("Debug Menu");
        onDraw();
/*
        if (isDev){
        }else {
            setVisible(false);
        }*/
    }

    public void isDev(boolean isDev) {
        this.isDev = isDev;
    }

    public void onDraw() {
        setVisible(true);
        setSize(500, 300);
        panel.add(label);
        setContentPane(panel);

    }

    public void showDebugText(String message) {
        label.setText(message);
    }


}
