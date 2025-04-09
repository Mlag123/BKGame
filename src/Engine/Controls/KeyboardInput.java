package Engine.Controls;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class KeyboardInput {
    private static final Set<Integer> pressedKeys = new HashSet<>();


    static {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(e -> {
                    synchronized (KeyboardInput.class){
                        if (e.getID() == KeyEvent.KEY_PRESSED){
                            pressedKeys.add(e.getKeyCode());
                        } else if (e.getID()== KeyEvent.KEY_RELEASED) {
                            pressedKeys.remove(e.getKeyCode());
                        }
                        return false;
                    }
                });
    }

    public static boolean isKeyPressed(int keycode){
        synchronized (KeyboardInput.class){
            return pressedKeys.contains(keycode);
        }
    }
}
