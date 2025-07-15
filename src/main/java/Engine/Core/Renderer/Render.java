package Engine.Core.Renderer;

import Engine.PanelGame;
import Engine.Ticker;
import Math.GameObjects.AbstractObject;
import Math.GameObjects.IHasRender;

import Math.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Render {
    private Ticker ticker = new Ticker(60);
    private Graphics2D g2 = PanelGame.g2;

    public Render() {

    }




    public void draw(AbstractObject obj, Vector2D deltaPosition) {

    }
/*    public void drawText(AbstractObject obj, Vector2D deltaPosition){
        AffineTransform oldTrans = g2.getTransform();
        g2.translate(deltaPosition.getX(), deltaPosition.getY());
        g2.setColor(obj.getColor);
        g2.drawString("text", (int) deltaPosition.getX(), (int) deltaPosition.getY());
        g2.setTransform(oldTrans);
        Logging.log(logs.warn, "update");
    }*/

    /*
       AffineTransform oldTrans = g2.getTransform();
        g2.translate(object.object_vector.getX(), object.object_vector.getY());
        g2.setColor(obj.getColor);
        g2.drawString("text", (int) deltaPosition.getX(), (int) deltaPosition.getY());
        g2.setTransform(oldTrans);
        Logging.log(logs.warn, "update");
     */
}
