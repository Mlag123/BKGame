package Entity;

import Engine.PanelGame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.lang.reflect.AnnotatedArrayType;

import Engine.TickListener;
import Engine.Ticker;
import Engine.Window;
import Math.Vector2D;
import Objects.Weapon.AbstractObject;

public class Player extends AbstractEntity {
    public static final double PLAYER_SIZE = 64;
    private double gravity = 150;
    //   private double x;
    //   private double y;
    //   public Ticker          ticker = new Ticker(1);
    private double dx = 0;
    private double dy = 0;
    private double speed = 0.1;
    private double maxSpeed = 0.2f;
    private double minSpeed = 0.1f;
    private float angle = 0;
    public boolean isGravity = true;
    private Vector2D playerVector;
    //  private final Image image;
    private boolean speedUP = false;
    //  private boolean speedDown = false;
    private final static Image player_sprite = new ImageIcon("./Resources/Sprites/PlayerSprite/PlayerChar.png").getImage();


    public Player() {
        super(player_sprite);


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


    public void moveUP() {
        if (!(y <= 0)) {
            double _y;
            _y = y;
            y = (_y - 700 * speed);
        } else {
            y = 0;
        }


    }

    public void gravity(AbstractObject object) {


        if (isGravity) {

            if (!((object.y - object.spriteHeight) - (y - spriteWidth+23) <= 0)) {

                double _y;
                _y = y;
                y = (_y + 20 * 0.1);
           //     System.out.println((object.y - object.spriteHeight) - (y - spriteWidth));


            } else {

            }
            //        System.out.println("PLAYER POS : Y"+y);

        }


    }

    public void moveDown() {
        double _y;
        _y = y;
        y = (_y + 20 * speed);

    }

    public void moveLeft() {
        //   x = (x - 120 * speed);


        if (!((Window.getWidthFrame() - (x)) >= Window.getWidthFrame())) {
            x = (x - 120 * speed);
        }

    }

    public void moveRight() {

        if (!(0 >= Window.getWidthFrame() - (x + spriteWidth + 23))) {
            x = (x + 120 * speed);
        }
//
//        if (x >= 1145) {
//            x = 1145;
//        } else {
//
//            x = x + 15 * speed / PanelGame.deltaTime;
//        }


    }


    public void update() {


    }
}
