package Entity;

import java.awt.*;
import java.awt.geom.AffineTransform;

import Math.Vector2D;

public class AbstractEntity {
    private Vector2D vector2D;
        public Vector2D getVector2D() {
        return vector2D;
    }
    public static final double ENTITY_SIZE = 64;
    private double x;
    private double y;
    private double deltaTime = 0.2;
    private double speed = 0.2;
    private final Image image_sprites;
    public AbstractEntity(Image imageSprites) {
        vector2D = new Vector2D(x, y);
        this.x = vector2D.getX();
        this.y = vector2D.getY();
        image_sprites = imageSprites;
    }
    public void draw(Graphics2D g2) {
        Vector2D normalizeVector = Vector2D.normalVector2D(new Vector2D(x, y));
        AffineTransform oldTrans = g2.getTransform();
        g2.translate(normalizeVector.getX(), normalizeVector.getY());
        g2.drawImage(image_sprites, oldTrans, null);

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
