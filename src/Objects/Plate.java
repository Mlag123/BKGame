package Objects;

import Math.GameObjects.AbstractObject;
import Utils.Tags;

import static Engine.Core.ResourceLoader.plate_Sprite;

public class Plate  extends AbstractObject {
   // private final  static ImageIcon image;

        private String tag;

    public Plate() {
        super(plate_Sprite, Tags.plate);

    }

}
