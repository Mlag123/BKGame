package Objects.Weapon;

import Math.GameObjects.AbstractObject;
import Utils.Tags;

import javax.swing.*;
import java.awt.*;

public class BulletAK47 extends AbstractObject {

    public BulletAK47() {
        super(new ImageIcon("./Resources/Sprites/Weapon/bulletAK.png").getImage(), Tags.object);
    }



    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
//        AffineTransform transform = new AffineTransform();
//        transform.rotate((Math.toRadians((angle+45))),Bullet_SIZE/2,Bullet_SIZE/2);
//        g2.drawImage(image_bullet,transform,null);
    }
}
