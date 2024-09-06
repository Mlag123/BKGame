package Math;


import Entity.AbstractEntity;
import Math.GameObjects.AbstractObject;

public class Vector2D {

    public double x, y;

    public Vector2D() {

    }

    public void changeCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void changeCoordinates(Vector2D vector2D) {
        this.y = vector2D.getX();
        this.x = vector2D.getY();
    }

    public static Vector2D subVector(Vector2D vec1, Vector2D vec2) {
        return new Vector2D(vec1.getX() - vec2.getX(), vec1.getY() - vec2.getY());
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;

    }


    public static double getLongVector(double x, double y) {

        return Math.sqrt((x * x) + (y * y));

    }

    public static Vector2D getSubWithSpritesVectorEntity(AbstractEntity abstractEntity, AbstractObject object) {
        Vector2D a = abstractEntity.object_vector;
        Vector2D b = object.object_vector;

        double x, y;
        x = ((b.getX()+object.spriteWidth)-(a.getX()+abstractEntity.spriteWidth));
        y = (b.getY()-object.spriteHeight)-(a.getY()-abstractEntity.spriteHeight)-27;


 //      System.out.println("playerX = "+a.getX()+"| playerY = "+a.getY()+"| x = "+x+"| y = "+y+"| obY = "+b.getY()+"| OBJ = "+object.getClass().getName() );

        return new Vector2D(x, y);

    }

    public static Vector2D normalVector2D(Vector2D vector2D) {
        double x = vector2D.getX(), y = vector2D.getY();
        double longVector = getLongVector(x, y);
        x = x / longVector;
        y = y / longVector;

        return new Vector2D(x, y);
    }

    public double getLongVector() {
        double x = getX(), y = getY();
        return Math.sqrt((x * x) + (y * y));

    }

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
}
