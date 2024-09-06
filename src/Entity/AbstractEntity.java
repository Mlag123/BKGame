package Entity;

import java.awt.*;
import java.awt.geom.AffineTransform;


import Engine.PanelGame;
import Engine.TickListener;
import Engine.Ticker;
import Entity.Inventory.Hand;
import Math.Vector2D;
import Objects.AbstractObject;
import Utils.Utils;

import static Engine.PanelGame.entityArrayList;

public abstract class AbstractEntity extends AbstractObject {

    private int health;
    private int armor;
    private Hand hand;

    private boolean isCollide = true;


    public AbstractEntity(Image imageSprites) {
        super(imageSprites);
        object_vector = new Vector2D();
        object_collision = new Rectangle((int) object_vector.getX(), (int) object_vector.getY(), spriteWidth, spriteHeight);
        PanelGame.entityArrayList.add(this);
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

    public void draw(Graphics2D g2) {
        object_collision.setBounds((int) object_vector.getX(), (int) object_vector.getY(), spriteWidth, spriteHeight);
        AffineTransform oldTrans = g2.getTransform();
        g2.translate(object_vector.getX(), object_vector.getY());
        //    System.out.println("x pos :"+x+" y pos "+ y+ "translating");
        g2.drawImage(image, 0, 0, null);
        g2.setTransform(oldTrans);

    }




}
