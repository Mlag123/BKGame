package Entity;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import Engine.Core.ResourceLoader;
import Engine.PanelGame;
import Engine.Window;
import Math.CollaiderSystem2D;
import Utils.Exceptions.GameObjectIsNull;
import Math.Physics;
import Math.RaycastSystem.Direction;
import Math.RaycastSystem.Raycast;
import Math.GameObjects.AbstractObject;
import Utils.Tags;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player extends AbstractEntity {
    public static final double PLAYER_SIZE = 64;
    private Physics physics = new Physics();
    private double gravity = 150;
   // private TextManager textManager = new TextManager();
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
    private Logger log = LogManager.getLogger(this.getClass());

    public Player() throws GameObjectIsNull {
        super(ResourceLoader.player_Sprite, Tags.player,PanelGame.g2);
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
            if ((rectangle2D.intersects(abstractObject.rectangle2D))) {
                return true;
            }
        }
        return true;
    }

    public void gravity() {
        if (isGravity) { //fixme?


            if  (limitWindow(this.object_vector,this,Direction.down,true)){ //fixme?


              try {
                  if (collaiderSystem2D.isGrounded(this,PanelGame.objectArrayList,Tags.plate)) { //fixme

                      double _y;
                      _y = y;
                      y = (_y + 20 * 0.2);
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
            y = (_y - 20);

        } else {
            isJumping = false;

            y=y-y;

          //  y = 0;
        }


    }

    public void moveDown() throws GameObjectIsNull {
        if (collaiderSystem2D.isGrounded(this,PanelGame.objectArrayList,Tags.plate)) {
            double _y;
            _y = y;
            y = (_y + 20 * speed);

        }
    }

    public void moveLeft() throws GameObjectIsNull {
        //   x = (x - 120 * speed);


        if (isCollide()) {
            if (!((Window.getWidthFrame() - (x)) >= Window.getWidthFrame())) {

                if(collaiderSystem2D.hasWallLeft(this,PanelGame.objectArrayList,Tags.wall)) {
                    x = x - 5 * speed;
                }else {
                    try {
                        PanelGame.sound.stop();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }

            }

        }
    }

    public void moveRight() throws GameObjectIsNull {
        if (!(0 >= Window.getWidthFrame() - (x + spriteWidth + 23))) {

            if (isCollide()) {

              /*  if(collaiderSystem2D.isCollisionEntered(this,PanelGame.objectArrayList,Tags.wall)){

                }*/

                if(collaiderSystem2D.hasWallRight(this,PanelGame.objectArrayList,Tags.wall)) {
                    x = x +5*speed;


                }else {
                    PanelGame.sound.play();


                }

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
