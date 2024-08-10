package Math;

import Entity.AbstractEntity;
import Objects.Weapon.AbstractObject;

public class Raycast {


    private double x, y;
    private Vector2D vector2D;


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2D getVector2D() {
        return vector2D;
    }

    public void setVector2D(Vector2D vector2D) {
        this.vector2D = vector2D;

    }

    public static AbstractObject getObject(Direction direction, Vector2D vector2D, AbstractEntity object){ //fixme


        if (direction == Direction.up) {
            

        } else if (direction == Direction.down) {

        } else if (direction == Direction.left) {

        } else if (direction == Direction.right) {

        }

        return  (AbstractObject) new Object();
    }


    /*
            if (isGravity) {

            if (!((object.y - object.spriteHeight) - (y - spriteWidth+23) <= 0)) {

                double _y;
                _y = y;
                y = (_y + 20 * 0.1);
                System.out.println((object.y - object.spriteHeight) - (y - spriteWidth));


            } else {

            }
            //        System.out.println("PLAYER POS : Y"+y);

        }

     */
}
