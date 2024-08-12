package Entity;

import java.awt.*;
import java.awt.geom.AffineTransform;


import Engine.PanelGame;
import Engine.TickListener;
import Engine.Ticker;
import Math.Vector2D;
import Utils.Utils;

import static Engine.PanelGame.entityArrayList;

public class AbstractEntity {

    public Vector2D vector2DEntity;
    private final Image image_sprites;
    public int spriteHeight;
    public int spriteWidth;

    public AbstractEntity(Image imageSprites) {
        PanelGame.entityArrayList.add(this);
        spriteHeight = imageSprites.getHeight(null);
        spriteWidth = imageSprites.getWidth(null);
        vector2DEntity = new Vector2D();
        image_sprites = imageSprites;
    }


    public Vector2D getVector2D() {
        return vector2DEntity;
    }

    public void draw(Graphics2D g2) {

        AffineTransform oldTrans = g2.getTransform();
        g2.translate(vector2DEntity.getX(), vector2DEntity.getY());
    //    System.out.println("x pos :"+x+" y pos "+ y+ "translating");
        g2.drawImage(image_sprites, 0, 0, null);
        g2.setTransform(oldTrans);
    }

    public void changeLocation(double x, double y) {
        Vector2D normalizeVector = Vector2D.normalVector2D(new Vector2D(x, y)); // FIXME: 26.02.2024
        vector2DEntity.setX(x);
        vector2DEntity.setY(y);
    }

    public Image getImage() {
        return image_sprites;
    }
}
