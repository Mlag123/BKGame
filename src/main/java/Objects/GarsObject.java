package Objects;

import Engine.Core.ResourceLoader;
import Engine.PanelGame;
import Math.GameObjects.AbstractObject;
import Utils.Tags;

import javax.swing.*;
import java.awt.*;

public class GarsObject extends AbstractObject {
    public GarsObject() {
        super(ResourceLoader.getImageFromResources("/Sprites/PlayerSprite/Gars.png"), Tags.GARS, PanelGame.g2);
    }
}
