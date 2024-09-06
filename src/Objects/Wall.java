package Objects;

import Math.GameObjects.AbstractObject;

import javax.swing.*;

public class Wall extends AbstractObject {
    public Wall() {
        super(new ImageIcon("./Resources/Sprites/Plate/wall.png").getImage());

    }
}
