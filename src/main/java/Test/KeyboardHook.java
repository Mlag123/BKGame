package Test;

import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;

public class KeyboardHook {

    AWTEventListener listener = new AWTEventListener() {
        @Override
        public void eventDispatched(AWTEvent event) {
            try{
                KeyEvent evt = (KeyEvent) event;
                if (evt.getID() == KeyEvent.KEY_PRESSED && evt.getModifiers() == KeyEvent.CTRL_MASK && evt.getKeyCode() == KeyEvent.VK_W) {
                    System.out.println("WWW");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {
        new KeyboardHook();
    }

}
