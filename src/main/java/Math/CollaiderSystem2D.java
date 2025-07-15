package Math;

import Math.GameObjects.AbstractObject;
import Utils.Exceptions.GameObjectIsNull;
import Utils.Tags;

import java.awt.*;
import java.awt.geom.Rectangle2D;
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

    public boolean intersectsDebug(Rectangle2D a, Rectangle2D b) {
        boolean result = a.intersects(b);
        System.out.printf("RectA: [x=%.2f, y=%.2f, w=%.2f, h=%.2f]%n",
                a.getX(), a.getY(), a.getWidth(), a.getHeight());
        System.out.printf("RectB: [x=%.2f, y=%.2f, w=%.2f, h=%.2f]%n",
                b.getX(), b.getY(), b.getWidth(), b.getHeight());
        System.out.printf("Intersects: %b%n", result);
        return result;
    }

    public boolean isGrounded(AbstractObject gameObject1, ArrayList<AbstractObject> objectsList, Tags tags) throws GameObjectIsNull {
        {

            AbstractObject gameObject = objectsList.stream()
                    .filter(obj -> obj.getTag().equals(tags))
                    .findFirst()
                    .orElseThrow(() -> new GameObjectIsNull("Objects with tag " + tags + " not found"));

            Rectangle2D bound1 = gameObject.rectangle2D;
            Rectangle2D bound2 = gameObject1.rectangle2D;




            return !bound1.intersects(bound2);
        }




      /*  public boolean isCollisionEntered(AbstractObject gameObject1, ArrayList<AbstractObject> arrayList, Tags tags) throws GameObjectIsNull {
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


 AbstractObject gameObject = objectsList.stream()
                    .filter(obj -> obj.getTag().equals(tags))
                    .findFirst()
                    .orElseThrow(() -> new GameObjectIsNull("Objects with tag " + tags + " not found"));

    }*/
    }

    public boolean hasWallLeft(AbstractObject playerBounds, ArrayList<AbstractObject> walls,Tags tag) throws GameObjectIsNull {

        AbstractObject _gameObject = walls.stream()
                .filter(obj -> obj.getTag().equals(tag))
                .findFirst()
                .orElseThrow(()-> new GameObjectIsNull("Object: "+tag + " - is not found"));


        Rectangle2D leftCheck = new Rectangle2D.Double(
                playerBounds.object_vector.getX() - 1, // -1 для проверки слева
                playerBounds.object_vector.getY() + 5,  // +5 чтобы игнорировать углы
                1,                       // Тонкая линия слева
                playerBounds.spriteHeight - 10 // Игнорируем верх/низ
        );



        return !leftCheck.intersects(_gameObject.rectangle2D);
    }

    // Возвращает true, если есть стена справа
    public boolean hasWallRight(AbstractObject playerBounds, ArrayList<AbstractObject> walls,Tags tag) throws GameObjectIsNull {


        AbstractObject _gameObject = walls.stream()
                .filter(obj -> obj.getTag().equals(tag))
                .findFirst()
                .orElseThrow(()-> new GameObjectIsNull("Object: "+tag + " - is not found"));

        Rectangle2D rightCheck = new Rectangle2D.Double(
                playerBounds.object_vector.getX() + playerBounds.spriteWidth,
                playerBounds.object_vector.getY() + 5,
                1,
                playerBounds.spriteHeight - 10
        );

        return !rightCheck.intersects(_gameObject.rectangle2D);
    }
}
