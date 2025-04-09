package Engine.SceneSystem;

import Engine.Controls.CustomKeyListener;
import Engine.PanelGame;
import Engine.Window;
import Math.GameObjects.IAbstractScene;
import Utils.Exceptions.GameObjectIsNull;
import Math.Vector2D;
import Utils.Tags;

import java.awt.*;



public abstract class AbstractScene implements IAbstractScene {

    private Tags tags;
    private Vector2D default_coordinate;
    private Vector2D coordinate_for_;
    private Graphics2D g2 = PanelGame.g2;

    public AbstractScene(Tags tags) throws GameObjectIsNull {
        default_coordinate = new Vector2D(0, 0);
        this.tags = tags;

    }

    public Tags getTags() {
        return tags;
    }




    public void drawBackground(Color color) {
        g2.setColor(color);
        g2.fillRect(0, 0, Window.getWidthFrame(), Window.getHeightFrame());
    }

    public void update() {

    }

    public void init() {

    }



}


