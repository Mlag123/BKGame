package Objects;

import Engine.PanelGame;
import Math.GameObjects.AbstractObject;
import Utils.Tags;

import javax.swing.*;

public class Wall extends AbstractObject {
    public Wall() {
        super(new ImageIcon("./Resources/Sprites/Plate/wall.png").getImage(), Tags.wall, PanelGame.g2);

    }


}
