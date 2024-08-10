package Objects.Weapon;

import Utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class BulletAK47 extends AbstractObject {

    public BulletAK47() {
        super(new ImageIcon("./Resources/Sprites/Weapon/bulletAK.png").getImage());
    }


    public void changeLocation(double x, double y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
//        AffineTransform transform = new AffineTransform();
//        transform.rotate((Math.toRadians((angle+45))),Bullet_SIZE/2,Bullet_SIZE/2);
//        g2.drawImage(image_bullet,transform,null);
    }
}
