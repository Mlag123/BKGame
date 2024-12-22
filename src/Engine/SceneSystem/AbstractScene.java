package Engine.SceneSystem;

import Engine.PanelGame;
import Engine.Window;
import Utils.Exceptions.GameObjectIsNull;
import Math.Vector2D;
import Utils.Tags;

import java.awt.*;



public abstract class AbstractScene {

    private Tags tags;
    private Vector2D default_coordinate;
    private Vector2D coordinate_for_;
    private Graphics2D g2;

    public AbstractScene(Tags tags) throws GameObjectIsNull {
        default_coordinate = new Vector2D(0, 0);
        this.tags = tags;
        if (g2 != null) {
            g2 = PanelGame.g2;
        } else {
            throw new GameObjectIsNull(this.getClass().getName() + " Graphics2D can not be null");
        }
    }

    public Tags getTags() {
        return tags;
    }

    public void draw() {


    }

    public void drawBackground(Color color) {

        g2.setColor(color);
        g2.fillRect(0, 0, Window.getWidthFrame(), Window.getHeightFrame());
    }

    public void updateObjects() {

    }

    public void initObjects() {

    }

}


