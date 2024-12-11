package Math.GameObjects;

import Engine.PanelGame;
import Engine.Window;
import Math.RaycastSystem.Direction;
import Math.Vector2D;
import Utils.Debuger;
import Utils.Tags;

import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class AbstractObject implements IHasRender {
    public Vector2D object_vector;
    public Rectangle object_collision;
    private Graphics2D g2 = PanelGame.g2;
    public final float speed = 0.3f;
    public static final double Bullet_SIZE = 42;
    public float angle = 0;
    public Image image;
    public int spriteHeight;
    public int spriteWidth;
    private Tags tag;
    private boolean isVisible = true; //default true!



    public AbstractObject(Image image, Tags tags) {
        this.tag = tags;
        object_vector = new Vector2D();
        object_collision = new Rectangle((int) object_vector.getX(), (int) object_vector.getX(), spriteWidth, spriteHeight);
        PanelGame.objectArrayList.add(this);
        spriteHeight = image.getHeight(null);
        spriteWidth = image.getWidth(null);
        this.image = image;

    }

    public AbstractObject(Tags tags) {
        this.tag = tags;
        object_vector = new Vector2D();
        object_collision = new Rectangle((int) object_vector.getX(), (int) object_vector.getX(), spriteWidth, spriteHeight);
        PanelGame.objectArrayList.add(this);

    }

    public void setVisible(boolean visible) {
        this.isVisible = visible;
    }

    public boolean getVisibleState() {
        return isVisible;
    }

    public Tags getTag() {
        return tag;
    }

    public Graphics2D getGraphics2D() {
        return g2;
    }

    public Image getImage() {
        return image;
    }

    public float getAngle() {
        return angle;
    }

    public void draw() {
        if (getVisibleState()) {
            object_collision.setBounds((int) object_vector.getX(), (int) object_vector.getY(), spriteWidth, spriteHeight);
            AffineTransform oldTrans = g2.getTransform();
            g2.translate(object_vector.getX(), object_vector.getY());
            g2.drawImage(image, 0, 0, null);

            g2.setTransform(oldTrans);
        }

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

    /**
     * this function for debugging game
     *
     * @param vector2D
     * @param object
     * @param direction
     * @return
     */
    public boolean limitWindow(Vector2D vector2D, AbstractObject object, Direction direction, boolean isLimit) {
        double x, y, dx, dy;
        x = vector2D.getX();
        y = vector2D.getY();
        dx = (x + object.spriteWidth);
        dy = (y + object.spriteHeight + 27);
        if (isLimit) {
            switch (direction) {
                case down:
                    if (dy <= Window.getHeightFrame()) {

                        //     System.out.println("down | " + this.getClass().getName());
                        return true;
                    }
                default:
                    return false;
            }
        }

        return false;
    }
}
