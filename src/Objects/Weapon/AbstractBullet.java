package Objects.Weapon;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class AbstractBullet {
    public double x, y;
    public final float speed = 0.3f;
    public static final double Bullet_SIZE = 42;
    public float angle = 0;
    public final Image image_bullet;

    public AbstractBullet(Image imageBullet) {
        image_bullet = imageBullet;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public float getAngle() {
        return angle;
    }

    public void draw(Graphics2D g2) {
        AffineTransform oldTrans = g2.getTransform();
        g2.translate(x, y);
        g2.drawImage(image_bullet, 0, 0, null);

        g2.setTransform(oldTrans);

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
