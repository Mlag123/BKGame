package Math.RaycastSystem;

import Engine.PanelGame;
import Entity.AbstractEntity;
import Math.GameObjects.AbstractObject;
import Math.Vector2D;
import Utils.Tags;
import java.util.ArrayList;

public class Raycast {


    public double x, y;
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

    /**
     * Is unknow will be used this function
     *
     * @param direction
     * @param x
     * @param y
     * @return
     */
    @Deprecated
    public Tags getTagObject(Direction direction, double x, double y) { //fixme



        if (direction == Direction.up) {

        } else if (direction == Direction.down) {
            for (AbstractObject _object : PanelGame.objectArrayList) {

                if (Vector2D.subVector(_object.object_vector, new Vector2D(x, y)).getY() <= 0) {
                    return _object.getTag();
                }

            }


        } else if (direction == Direction.left) {

        } else if (direction == Direction.right) {
        }

        // return (AbstractObject) new Object();
        return null;
    }

    /**
     * This Raycast function
     * In relation to "direction" will, search another object. Returns it, if on the way has object;
     * Accepts arguments "Direction, Tags".
     *
     * @param direction
     * @param tags
     * @return
     */
    public Tags getTagObject(Direction direction, Tags tags) {
        Vector2D player_vector = PanelGame.player.getVector2D();
        double pH = PanelGame.player.spriteHeight;
        double pW = PanelGame.player.spriteWidth;
        ArrayList<AbstractObject> objectsList = PanelGame.objectArrayList;
        double distanteToObj = 0;

        AbstractObject gameObject2 = null;
        for (AbstractObject obj : objectsList) {
            if (obj.getTag().equals(tags)) {
                gameObject2 = obj;
            }
        }


        if (!(gameObject2 == null)) {
            if (direction == Direction.up) { //проверить
                y--;
                distanteToObj = (player_vector.getY() + pH) - (gameObject2.object_vector.getY() - gameObject2.spriteHeight);
                if (distanteToObj <= 0) {
                    return gameObject2.getTag();
                }
            } else if (direction == Direction.down) { //проверить
                y++;
                distanteToObj = (player_vector.getY() - pH) - (gameObject2.object_vector.getY() + gameObject2.spriteHeight);
                if (distanteToObj <= 0) {
                    return gameObject2.getTag();
                }

            } else if (direction == Direction.left) {
                x--;
                distanteToObj = (player_vector.getX() - pW) - (gameObject2.object_vector.getX() + gameObject2.spriteWidth);
                if (distanteToObj <= 0) {
                    return gameObject2.getTag();
                }
            } else if (direction == Direction.right) {
                x++;

                distanteToObj = (player_vector.getX() + pW) - (gameObject2.object_vector.getX() - gameObject2.spriteWidth);
                if (distanteToObj <= 0) {
                    return gameObject2.getTag();
                }
            }
        }

        return null;
    }

    public boolean isCollide(Direction direction, AbstractEntity abEnt) { //fixme


        if (direction == Direction.up) {

        } else if (direction == Direction.down) {
            for (AbstractObject _object : PanelGame.objectArrayList) {
                Vector2D vector = Vector2D.getSubWithSpritesVectorEntity(abEnt, _object);
                double x, y;
                x = vector.getX();
                y = vector.getY();
                if (y >= 0 | x <= 0) {
                    return true;
                }
            }

        } else if (direction == Direction.left) {

        } else if (direction == Direction.right) {

        }

        return false;
    }

}
