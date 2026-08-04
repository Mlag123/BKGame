package Math;


import Entity.AbstractEntity;
import Math.GameObjects.AbstractObject;

public class Vector2D {
    public static Vector2D ZERO_VECTOR = new Vector2D(0, 0);
    public double x, y;

    public Vector2D() {


    }



    public static Vector2D additionVectors(Vector2D position, Vector2D velocity) {
        double x = position.getX(), y = position.getY(), dx = velocity.getX(), dy = velocity.getY();
        return new Vector2D(x + dx, y + dy);
    }
    public static Vector2D additionVectors(Vector2D position, double dx,double dy) {
        double x = position.getX(), y = position.getY();
        return new Vector2D(x + dx, y + dy);
    }


    public static Vector2D additionVectors(Vector2D position, Vector2D velocity, float deltatime) {
        double x = position.getX(), y = position.getY(), dx = velocity.getX(), dy = velocity.getY();
        double resX, resY;
        resX = x + dx * deltatime;
        resY = y + dy * deltatime;

        return new Vector2D(resX, resY);
    }
    public static Vector2D additionVectors(Vector2D position, float dx,float dy, float deltatime) {
        double x = position.getX(), y = position.getY();
        double resX, resY;
        resX = x + dx * deltatime;
        resY = y + dy * deltatime;

        return new Vector2D(resX, resY);
    }


    public void additionVectors(Vector2D velocity){
        this.x += velocity.getX();
        this.y +=velocity.getY();
    }
    public void additionVectors(double x,double y){
        this.x += x;
        this.y += y;
    }

    public void additionVectors(Vector2D velocity, float deltatime){
        this.x +=velocity.getX()*deltatime;
        this.y += velocity.getY()*deltatime;
    }

    public void additionVectors(double dx,double dy,float deltatime){

        this.x +=dx*deltatime;
        this.y +=dy*deltatime;
    }

    public Vector2D copy(){
        return new Vector2D(this.x,this.getY());
    }






    public void changeCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public void changeCoordinates(Vector2D vector2D) {
        this.x = vector2D.getX();
        this.y = vector2D.getY();
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
        x = ((b.getX() + object.spriteWidth) - (a.getX() + abstractEntity.spriteWidth));
        y = (b.getY() - object.spriteHeight) - (a.getY() - abstractEntity.spriteHeight); //-27!

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
        return Math.abs(Math.sqrt((x * x) + (y * y)));

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
