package Objects;

import Math.GameObjects.AbstractObject;
import Utils.Tags;

import javax.swing.*;

public class Plate  extends AbstractObject {
   // private final  static ImageIcon image;

        private String tag;

    public Plate() {
        super(new ImageIcon("./Resources/Sprites/Plate/plate.png").getImage(), Tags.plate);

    }

}
