package Engine.Core;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.net.URLClassLoader;

public class ResourceLoader {

    private Image sprite;
    public static Image player_Sprite = getImageFromResources("/Sprites/PlayerSprite/PlayerChar.png");
    public static Image plate_Sprite = getImageFromResources("/Sprites/Plate/plate.png");

    static {
        ClassLoader cl = ResourceLoader.class.getClassLoader();

        if(cl instanceof URLClassLoader){
            URLClassLoader urlClassLoader = (URLClassLoader) cl;
            System.out.println("ClassLoader: " +  urlClassLoader);
            System.out.println("\n");
            for(URL url : urlClassLoader.getURLs()){
                System.out.println(" "+url.getPath());
            }
        }
    }

    public static URL getImagePath(String nameFile) {
        URL resURL = ResourceLoader.class.getResource(nameFile);
        System.out.println( resURL);
        return resURL;
    }
    public static Image getImageFromResources(String pathSprite){
        Image _image = new ImageIcon(getImagePath(pathSprite)).getImage();
        return _image;
    }
    public static String testMusic = "/Sounds/main.wav";



}


