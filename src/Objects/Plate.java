package Objects;

import Math.GameObjects.AbstractObject;
import Utils.Tags;

import javax.swing.*;

import static Engine.Core.TextureLoader.plate_Sprite;

public class Plate  extends AbstractObject {
   // private final  static ImageIcon image;

        private String tag;

    public Plate() {
        super(plate_Sprite, Tags.plate);

    }

}
