package Engine.SceneSystem;

import Engine.PanelGame;
import Math.GameObjects.GameObjectIsNull;
import Math.Vector2D;

import java.awt.*;

public abstract class AbstractScene {

    private Vector2D default_coordinate;
    private Vector2D coordinate_for_;
    private Graphics2D g2;
    public AbstractScene() throws GameObjectIsNull {
        default_coordinate = new Vector2D(0,0);
        if (g2!=null){
            g2 = PanelGame.g2;
        }else {
            throw new GameObjectIsNull(this.getClass().getName()+" Graphics2D can not be null");
        }
    }
    public void draw(){


    }
}


class default_scene extends AbstractScene{


    public default_scene() throws GameObjectIsNull {
    }
}
