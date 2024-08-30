package Engine.Core;

import java.awt.*;
import java.net.URL;

public class TextureLoader {

    private Image sprite;


    public static URL getImagePath(String nameFile) {
        URL resURL = TextureLoader.class.getResource("/" + nameFile);
        return resURL;
    }
}
