package Entity;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.logging.Logger;


import Engine.PanelGame;
import Engine.Window;
import Entity.Inventory.Hand;
import Entity.Inventory.Inventory;
import Math.RaycastSystem.Direction;
import Math.Vector2D;
import Math.GameObjects.AbstractObject;
import Utils.Debuger;
import Utils.Tags;

public abstract class AbstractEntity extends AbstractObject {

    private int health;
    private int armor;
    private Hand hand;
    private Inventory inventory;
    private Graphics2D g2 = null;


    private boolean isCollide = true;


    public AbstractEntity(Image imageSprites, Tags tags,Graphics2D g2) {
        super(imageSprites,tags,g2);
        this.g2 = g2;
        object_vector = new Vector2D();
        rectangle2D = new Rectangle((int) object_vector.getX(), (int) object_vector.getY(), spriteWidth, spriteHeight);
        spriteHeight = imageSprites.getHeight(null);
        spriteWidth = imageSprites.getWidth(null);
        image = imageSprites;
    }

    public void ShowDebugText(Graphics2D g2d) {
        Graphics g = (Graphics) g2d;
        int x, y;
        x = (int) object_vector.getX();
        y = (int) object_vector.getY() + spriteHeight + 20;


        g.drawString("pX = " + object_vector.getX() + "| pY = " + object_vector.getY(), x, y);
        //  g2d.drawString("pX = " + vector2DEntity.getX() + "| pY = " + vector2DEntity.getY(), 200,300);

    }


    public Vector2D getVector2D() {
        return object_vector;
    }

    public void draw() {
        if(g2 !=  null){
            rectangle2D.setRect((int) object_vector.getX(), (int) object_vector.getY(), spriteWidth, spriteHeight);
            AffineTransform oldTrans = g2.getTransform();
            g2.translate(object_vector.getX(), object_vector.getY());
            g2.drawImage(image, 0, 0, null);
            g2.setTransform(oldTrans);

        }

    }



}
