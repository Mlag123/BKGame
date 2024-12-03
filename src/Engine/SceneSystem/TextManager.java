package Engine.SceneSystem;

import java.awt.*;
import java.awt.geom.AffineTransform;

import Engine.PanelGame;
import Math.Vector2D;
import logging.Logging;


public class TextManager {

    private Graphics2D g2 = PanelGame.g2;


    public TextManager() {

    }

    //первое ебать текст, второе позиция его, третье его цвет,первое дельта x, и второе дельта игрик
    public void draw(String text, Vector2D position, Color color,int dx,int dy) {
        AffineTransform oldTrans = g2.getTransform();
        g2.translate(position.getX(), position.getY());
        g2.setColor(color);
        g2.drawString(text, dx, dy);
        g2.setTransform(oldTrans);
    }

/*    public void drawText(String text, Vector2D vector_position) {
        //     Dimension dimension = new Dimension(w,h);
        AffineTransform oldTrans = g2.getTransform();
        g2.translate(vector_position.getX(), vector_position.getY());
        g2.drawString(text, (int) vector_position.getX(), (int) vector_position.getY());

        g2.setTransform(oldTrans);

    }*/


}
