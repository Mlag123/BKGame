package Entity;

import Engine.PanelGame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.lang.reflect.AnnotatedArrayType;

import Math.Vector2D;

public class Player {
    public static final double PLAYER_SIZE = 64;
    private double gravity = 150;
    private double x;
    private double y;
    private double dx = 0;
    private double dy = 0;
    private double speed = 0;
    private double maxSpeed = 0.2f;
    private double minSpeed = 0.1f;
    private float angle = 0;
    //  private final Image image;
    private boolean speedUP = false;
    //  private boolean speedDown = false;


    public Player() {
        super(new ImageIcon("./Resources/Sprites/PlayerSprite/PlayerChar.png").getImage());
        //      this.image = new ImageIcon("./Resources/Sprites/PlayerSprite/PlayerChar.png").getImage();
        playerVector = getVector2D();
        this.x = playerVector.getX();
        this.y = playerVector.getY();



    }

//    public void changeLocation(double x, double y) {
//        this.x = x;
//        this.y = y;
//
//    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public float getAngle() {
        return angle;
    }

    public void ChangeAngle(float angle) {
        if (angle < 0) {
            angle = 359;
        } else if (angle > 359) {
            angle = 0;
        }
        this.angle = angle;

    }

    @Override
    public void draw(Graphics2D g2) {
        AffineTransform oldTrans = g2.getTransform();
        g2.translate(x, y);
        g2.drawImage(image, oldTrans, null);

        g2.setTransform(oldTrans);

    }

    public void moveUP() {


        if (dy <= 0) {
            dy = -0;
        } else {

            dy = dy - 15 * speed / PanelGame.deltaTime;
        }
    }

    public void gravity() {
//        if (dy >= 720 - 165) {
//            dy = 720 - 165;
//        } else {
//            dy = dy + 0.2 * gravity;
//        }



    }

    public void moveDown() {
//
//        if (y >= 720 - 165) {
//            y = 720 - 165;
//        } else {
//            y = y + 15 * speed / PanelGame.deltaTime;
//        }
    }

    public void moveLeft() {
//        if (speed > maxSpeed) {
//            speed = maxSpeed;
//        } else if (speed <= 0) {
//            speed -= 0.01f;
//        } else {
//            speed += 0.01f;
//        }
//        if (x <= 0) {
//            x = 0;
//        } else {
//            x = x - 15 * speed / PanelGame.deltaTime;
//            System.out.println(x);
//        }
    }

    public void moveRight() {

        if (speed > maxSpeed) {
            speed = maxSpeed;
        } else if (speed <= 0) {
            speed += 0.01f;
        } else {
            speed += 0.01f;
        }
//
//
//        if (x >= 1145) {
//            x = 1145;
//        } else {
//
//            x = x + 15 * speed / PanelGame.deltaTime;
//        }


    }


    public void speedDown() {


    }

    public void update() {

        speed = 0.5;

        y = dy;
        x = dx;

     /*   y = y + 1;
        if (x >= 1280) {
            this.x = 1280;
        } else if (x <= 0) {
            x = 0;
        }*/
    }
}
