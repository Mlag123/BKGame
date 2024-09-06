package Utils;

import javax.swing.*;

public class Debuger extends JFrame {

    private boolean isDev = false;
    public Debuger(){
        super("Debug Menu");
        if (isDev){
            onDraw();
        }else {
            setVisible(false);
        }
    }
    public void isDev(boolean isDev){
        this.isDev = isDev;
    }
    public void onDraw(){
        setVisible(true);
        setSize(800,600);

    }

}
