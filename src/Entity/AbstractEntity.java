package Entity;

import java.awt.*;
import java.awt.geom.AffineTransform;


import Engine.PanelGame;
import Engine.TickListener;
import Engine.Ticker;
import Math.Vector2D;

import static Engine.PanelGame.entityArrayList;

public class AbstractEntity {


    public final Vector2D vector2D;
    public double x;
    public double y;
    private double deltaTime = 0.2;
    private double speed = 0.2;
    private final Image image_sprites;
    public int spriteHeight;
    public int spriteWidth;

    public AbstractEntity(Image imageSprites) {
        PanelGame.entityArrayList.add(this);
        spriteHeight = imageSprites.getHeight(null);
        spriteWidth = imageSprites.getWidth(null);
        vector2D = new Vector2D(x, y);
        this.x = vector2D.getX();
        this.y = vector2D.getY();
        image_sprites = imageSprites;
    }

    public Vector2D getVector2D() {
        return vector2D;
    }

    public void draw(Graphics2D g2) {

        AffineTransform oldTrans = g2.getTransform();
        g2.translate(x, y);
        g2.drawImage(image_sprites, 0, 0, null);
        g2.setTransform(oldTrans);

    }

    public void changeLocation(double x, double y) {
        Vector2D normalizeVector = Vector2D.normalVector2D(new Vector2D(x, y)); // FIXME: 26.02.2024
        vector2D.setX(normalizeVector.getX());
        vector2D.setY(normalizeVector.getY());
    }

    public Image getImage() {
        return image_sprites;
    }
}
