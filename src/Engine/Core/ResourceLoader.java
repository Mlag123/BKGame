package Engine.Core;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ResourceLoader {

    private Image sprite;
    public static Image player_Sprite = getImageFromResources("/Sprites/PlayerSprite/PlayerChar.png");
    public static Image plate_Sprite = getImageFromResources("/Sprites/Plate/plate.png");

    public static URL getImagePath(String nameFile) {
        URL resURL = ResourceLoader.class.getResource(nameFile);
        System.out.println( nameFile);
        return resURL;
    }
    public static Image getImageFromResources(String pathSprite){
        Image _image = new ImageIcon(getImagePath(pathSprite)).getImage();
        return _image;
    }
    public static String testMusic = "./Resources/Sounds/main.wav";
}
