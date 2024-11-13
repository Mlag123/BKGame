package Entity;

import javax.swing.*;
import javax.swing.text.html.HTML;
import java.awt.*;
import java.util.ArrayList;

import Engine.PanelGame;
import Engine.Window;
import Math.GameObjects.CollaiderSystem2D;
import Math.GameObjects.GameObjectIsNull;
import Math.GameObjects.Physics;
import Math.RaycastSystem.Direction;
import Math.RaycastSystem.Raycast;
import Math.GameObjects.AbstractObject;
import Utils.Tags;

public class Player extends AbstractEntity {
    public static final double PLAYER_SIZE = 64;
    private Physics physics = new Physics();
    private double gravity = 150;
    //  private  Vector2D playerVector;
    private double dx = 0;
    private double dy = 0;
    private double x, y;
    private double speed = 1.2;
    private double maxSpeed = 0.2f;
    private double minSpeed = 0.1f;
    private float angle = 0;
    private boolean isJumping;
    private boolean isMoving;
    private boolean isFalling;
    public boolean isGravity = true;
    private boolean speedUP = false;
    private Raycast raycast;
    private Boolean isCollides;
    private String text;
    private CollaiderSystem2D collaiderSystem2D = new CollaiderSystem2D(this);
    private final static Image player_sprite = new ImageIcon("./Resources/Sprites/PlayerSprite/PlayerChar.png").getImage();
    private ArrayList<AbstractObject> abstractObjectsList = PanelGame.objectArrayList;


    public Player() throws GameObjectIsNull {
        super(player_sprite, Tags.player);
        raycast = new Raycast();

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




    public void restart_player() {
        x = 0;
        y = 0;
    }

    public boolean isCollide() {
        for (AbstractObject abstractObject : abstractObjectsList) {
            //       System.out.println(player_collision.intersects(abstractObject.object_collision));
            if ((object_collision.intersects(abstractObject.object_collision))) {
                return true;
            }
        }
        return true;
    }

    public void gravity() {
        if (isGravity) {


            if  (limitWindow(this.object_vector,this,Direction.down)){



              try {
                  if (!collaiderSystem2D.isCollisionEntered(this,PanelGame.objectArrayList,Tags.plate)) {


                      double _y;
                      _y = y;
                      y = (_y + 20 * 0.2);
                      //     System.out.println(new Raycast().getObject(Direction.down, x, y));
                  } else {
                      y = y;
                  }
              } catch (GameObjectIsNull e) {
                  throw new RuntimeException(e);
              }

            }




        }


    }


    public void moveUP() {


        if (!(y <= 0)) {
            isJumping = true;
            double _y;
            _y = y;
            y = (_y - 150 * speed);

        } else {
            isJumping = false;

            y = 0;
        }


    }

    public void moveDown() throws GameObjectIsNull {
        if (!collaiderSystem2D.isCollisionEntered(this,PanelGame.objectArrayList,Tags.plate)) {
            double _y;
            _y = y;
            y = (_y + 20 * speed);

        }
    }

    public void moveLeft() {
        //   x = (x - 120 * speed);


        if (isCollide()) {
            if (!((Window.getWidthFrame() - (x)) >= Window.getWidthFrame())) {
                x = x -5*speed;
            }

        }
    }

    public void moveRight() throws GameObjectIsNull {
        if (!(0 >= Window.getWidthFrame() - (x + spriteWidth + 23))) {
            if (isCollide()) {
                if(collaiderSystem2D.isCollisionEntered(this,PanelGame.objectArrayList,Tags.wall)){
                }
                x = x +5*speed;

            }
        }

//
//        if (x >= 1145) {
//            x = 1145;
//        } else {
//
//            x = x + 15 * speed / PanelGame.deltaTime;
//     }


    }


    public void update() {
        //  System.out.println("x pos :"+x+" y pos "+ y);

        //    System.out.println("X = "+x+" Y = "+y);

     if (getVisibleState()){
         object_vector.changeCoordinates(x, y);
     }
        //   System.out.println(x+" "+y);

      /*  Raycast raycast = new Raycast();
        AbstractObject a = raycast.getObject(Direction.down,this.getX(),this.getY());*/


    }
}
