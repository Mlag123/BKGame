package Entity.Inventory;

import Engine.PanelGame;
import Math.GameObjects.AbstractObject;
import Utils.Tags;

import java.awt.*;

public class Hand extends AbstractObject {
    public Hand(Image image, Tags tags) {
        super(image, tags, PanelGame.g2);
    }
}
