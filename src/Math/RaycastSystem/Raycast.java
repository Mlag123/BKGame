package Math.RaycastSystem;

import Engine.PanelGame;
import Entity.AbstractEntity;
import Entity.Player;
import Math.GameObjects.AbstractObject;
import Math.Vector2D;
import Utils.Tags;

import javax.swing.*;
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
        //   ArrayList<AbstractObject> abstractObjects = PanelGame.objectArrayList;
        //    Rectangle r = new Rectangle(10,10,101,0);


        if (direction == Direction.up) {

        } else if (direction == Direction.down) {
            for (AbstractObject _object : PanelGame.objectArrayList) {
                //  long distance = (long) Math.sqrt(Math.pow(_object.getX() - x, 2) - Math.pow((_object.getY()) - y, 2));
                //System.out.println("pos x = " + x + "| pos y = "+y+"| distance = "+distance+"| Object x = "+_object.getX()+"| Object y = "+ _object.getY());
                //System.out.println("\n object name = "+_object.getClass().getName());
                if (Vector2D.subVector(_object.object_vector, new Vector2D(x, y)).getY() <= 0) {
                    //      System.out.println("я сосиска"+" "+_object.getClass().getName()+" "+Vector2D.subVector(_object.object_vector, new Vector2D(x, y)).getY());

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
        Vector2D unk_object;

        AbstractObject gameObject2 = null;
        for (AbstractObject obj : objectsList) {
            if (obj.getTag().equals(tags)) {
                gameObject2 = obj;
            }
        }


     if (!(gameObject2 == null)){
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

/*
        if (direction == Direction.up) {

        } else if (direction == Direction.down) {
            for (AbstractObject _object : PanelGame.objectArrayList) {
                //  long distance = (long) Math.sqrt(Math.pow(_object.getX() - x, 2) - Math.pow((_object.getY()) - y, 2));
                //System.out.println("pos x = " + x + "| pos y = "+y+"| distance = "+distance+"| Object x = "+_object.getX()+"| Object y = "+ _object.getY());
                //System.out.println("\n object name = "+_object.getClass().getName());
                if (Vector2D.subVector(_object.object_vector, new Vector2D(x, y)).getY() <= 0) {
                    //      System.out.println("я сосиска"+" "+_object.getClass().getName()+" "+Vector2D.subVector(_object.object_vector, new Vector2D(x, y)).getY());

                    return _object.getTag();
                }

            }


        } else if (direction == Direction.left) {

        } else if (direction == Direction.right) {

        }*/

        // return (AbstractObject) new Object();
        return null;
    }

    public boolean isCollide(Direction direction, AbstractEntity abEnt) { //fixme
        //   ArrayList<AbstractObject> abstractObjects = PanelGame.objectArrayList;
        //    Rectangle r = new Rectangle(10,10,101,0);


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

        // return (AbstractObject) new Object();
        return false;
    }


//         if (Vector2D.subVector(new Vector2D(_object.object_vector.getX() + _object.spriteHeight, _object.object_vector.getY() + _object.spriteHeight), new Vector2D(x, y)).getY() <= 0) {
//                    //      System.out.println("я сосиска"+" "+_object.getClass().getName()+" "+Vector2D.subVector(_object.object_vector, new Vector2D(x, y)).getY());
//                    return true;
//                }

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
