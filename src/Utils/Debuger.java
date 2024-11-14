package Utils;

import javax.swing.*;
import java.util.ArrayList;

public class Debuger implements Runnable {

    private ArrayList<JLabel> arrayListLabels = new ArrayList<>();
    private JFrame frame = new JFrame();
    private boolean isDev = true;
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();


    public Debuger() {
        Thread debugThread = new Thread(this);
        debugThread.start();


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
        frame.setVisible(true);
        frame.setTitle("Debug Menu");
        frame.setSize(500, 300);
        panel.add(label);
        frame.setContentPane(panel);

    }

    public void showDebugText(String message) {

        label.setText(message + " " + Utils.getMem());


    }


    @Override
    public void run() {
        onDraw();
    }
}
