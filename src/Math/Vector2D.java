package Math;


import java.util.Vector;
import java.util.logging.Logger;

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


    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;

    }


    public static double getLongVector(double x, double y) {

        return Math.sqrt((x * x) + (y * y));

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
