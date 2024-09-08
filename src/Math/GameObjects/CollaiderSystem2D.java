package Math.GameObjects;

import Math.Vector2D;

public class CollaiderSystem2D {

    private Vector2D collaiderVector;
    private int width;
    private int height;
    private int dog_H;

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

/*    public boolean isCollisionEntered(AbstractObject gameObject1, AbstractObject gameObject2) {
        Vector2D vectorGameObject = gameObject1.object_vector;
        Vector2D vectorGameObject2 = gameObject2.object_vector;
        //CollaiderSystem2D collaiderSystem2D = gameObject1.object_collision;
        if () {

        }


    }*/

}
