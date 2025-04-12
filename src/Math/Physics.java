package Math;

public class Physics {

    private double Mass;
    private double speed = 0.2;
    private double acceleration;
    private double gravity_const = 9.81;

    private Vector2D vector2D;


    public double Gravity(double mass,double y) {
// 20kg, sila_gravty 5,start_speed = 0;

        double _mass = mass / 10;
        double result = y*gravity_const * mass * speed;

        return result;
    }
}
