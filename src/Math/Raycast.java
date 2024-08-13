package Math;

import Engine.PanelGame;
import Objects.AbstractObject;

public class Raycast {


    public double x, y;
    private Vector2D vector2D;


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

    public Vector2D getVector2D() {
        return vector2D;
    }

    public void setVector2D(Vector2D vector2D) {
        this.vector2D = vector2D;

    }

    public AbstractObject getObject(Direction direction, double x, double y) { //fixme
        //   ArrayList<AbstractObject> abstractObjects = PanelGame.objectArrayList;
    //    Rectangle r = new Rectangle(10,10,101,0);


        if (direction == Direction.up) {

        } else if (direction == Direction.down) {
            for (AbstractObject _object : PanelGame.objectArrayList) {
              //  long distance = (long) Math.sqrt(Math.pow(_object.getX() - x, 2) - Math.pow((_object.getY()) - y, 2));
                //System.out.println("pos x = " + x + "| pos y = "+y+"| distance = "+distance+"| Object x = "+_object.getX()+"| Object y = "+ _object.getY());
                //System.out.println("\n object name = "+_object.getClass().getName());
                if (!(Math.sqrt(Math.pow(_object.angle - x, 2) - Math.pow((_object.angle - y), 2)) <= 0)) {
                    System.out.println("pos x = " + x + "| pos y = "+y+"| Object x = "+_object.angle+"| Object y = "+ _object.angle+"| object = "+_object.getClass().getName());
                    return _object;
                    //��������� �������� ��  ����� � ������ MAth.abd(AB), � ����� ������������� ����, ���������� ���

                }

            }


        } else if (direction == Direction.left) {

        } else if (direction == Direction.right) {

        }

        // return (AbstractObject) new Object();
        return null;
    }


    /*
            if (isGravity) {

            if (!((object.y - object.spriteHeight) - (y - spriteWidth+23) <= 0)) {

                double _y;
                _y = y;
                y = (_y + 20 * 0.1);
                System.out.println((object.y - object.spriteHeight) - (y - spriteWidth));


            } else {

            }
            //        System.out.println("PLAYER POS : Y"+y);

        }

     */
}
