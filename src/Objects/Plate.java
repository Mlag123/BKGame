package Objects;

import Objects.Weapon.AbstractObject;

import javax.swing.*;
import java.awt.*;

public class Plate  extends AbstractObject {
   // private final  static ImageIcon image;


    public void changeLocation(double x, double y) {
        this.x = x;
        this.y = y;

    }
    public Plate() {
        super(new ImageIcon("./Resources/Sprites/Plate/plate.png").getImage());

    }

}
