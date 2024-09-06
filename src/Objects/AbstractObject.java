package Objects;

import Engine.PanelGame;
import Math.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class AbstractObject {
    public Vector2D object_vector;
    public Rectangle object_collision;
    public final float speed = 0.3f;
    public static final double Bullet_SIZE = 42;
    public float angle = 0;
    public Image image;
    public int spriteHeight;
    public int spriteWidth;
    private String tag;

    public AbstractObject(Image image) {
        object_vector = new Vector2D();
        object_collision = new Rectangle((int) object_vector.getX(), (int) object_vector.getX(), spriteWidth, spriteHeight);
        PanelGame.objectArrayList.add(this);
        spriteHeight = image.getHeight(null);
        spriteWidth = image.getWidth(null);
        this.image = image;

    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Image getImage() {
        return image;
    }

    public float getAngle() {
        return angle;
    }

    public void draw(Graphics2D g2) {
        object_collision.setBounds((int)object_vector.getX(),(int)object_vector.getY(),spriteWidth,spriteHeight);
        AffineTransform oldTrans = g2.getTransform();
        g2.translate(object_vector.getX(), object_vector.getY());
        g2.drawImage(image, 0, 0, null);

        g2.setTransform(oldTrans);

    }

    public void changeLocation(double x, double y) {
        object_vector.setX(x);
        object_vector.setY(y);

    }

    public void ChangeAngle(float angle) {
        if (angle < 0) {
            angle = 359;
        } else if (angle > 359) {
            angle = 0;
        }
        this.angle = angle;
    }
}
