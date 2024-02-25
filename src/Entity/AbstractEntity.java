package Entity;

import java.awt.*;
import Math.Vector2D;
public class AbstractEntity {
    private Vector2D vector2D;

    @Deprecated
    public Vector2D getVector2D() {
        return vector2D;
    }

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
