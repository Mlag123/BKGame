package Entity;

import java.awt.*;

public class AbstractEntity {
    public static final double ENTITY_SIZE = 64;
    private double x;
    private double y;

    private double deltaTime = 0.2;
    private double speed = 0.2;
    private final Image image_sprites;

    public AbstractEntity(Image imageSprites) {

        image_sprites = imageSprites;
    }

}
