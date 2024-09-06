package Math.GameObjects;

import Entity.AbstractEntity;
import Objects.AbstractObject;
import Math.Vector2D;

public class CollaiderSystem2D {

    private Vector2D collaiderVector;
    private int width;
    private int height;

    public Vector2D getCollaiderVector() {
        return collaiderVector;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public CollaiderSystem2D(AbstractObject abstractObject) throws GameObjectIsNull {

        if (abstractObject != null) {
            collaiderVector = abstractObject.object_vector;
            width = abstractObject.spriteWidth;
            height = abstractObject.spriteHeight;
        } else {
            throw new GameObjectIsNull("GameObject is null");
        }

    }

/*    public boolean isCollisionEntered(AbstractObject object,CollaiderSystem2D collaider){




    }*/

}
