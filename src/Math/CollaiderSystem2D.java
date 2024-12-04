package Math;

import Math.GameObjects.AbstractObject;
import Utils.Exceptions.GameObjectIsNull;
import Utils.Tags;

import java.util.ArrayList;

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
    //наудивлене частично коим боком это как то работает
    public boolean isCollisionEntered(AbstractObject gameObject1, ArrayList<AbstractObject> arrayList, Tags tags) throws GameObjectIsNull {
        AbstractObject gameObject2 = null;
        for (AbstractObject obj : arrayList) {
            if (obj.getTag().equals(tags)) {
                gameObject2 = obj;

            }
        }

        Vector2D objVEC_1 = gameObject1.object_vector;
        Vector2D objVEC_2;
        try {
            objVEC_2 = gameObject2.object_vector;

        } catch (NullPointerException e) {
            throw new GameObjectIsNull(e.getMessage());
        }
        double _x = (objVEC_1.getX() + gameObject1.spriteWidth) - (objVEC_2.getX() + gameObject2.spriteWidth);
        double _y = (objVEC_1.getY() - gameObject1.spriteHeight) - (objVEC_2.getY() - gameObject2.spriteHeight-23); // FIXME: 01.10.2024
        double width_center = (double) gameObject2.spriteWidth / 2;
        double height_center = (double) gameObject2.spriteHeight / 2;
        double xWCenter = objVEC_2.getX() + width_center;
        double yHCenter = objVEC_2.getY() + height_center;


        if (gameObject1.object_vector.getX()+gameObject1.spriteWidth<= (xWCenter+ (gameObject2.spriteWidth/2))){
            if (_y >= 0) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }




    }

}
