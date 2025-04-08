package Engine.Controls;

import Entity.AbstractEntity;
import Entity.Player;
import Utils.Exceptions.GameObjectIsNull;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CustomKeyListener implements  Runnable{
   //private AbstractEntity entity;


    public CustomKeyListener() {



    }

    @Override
    public void run() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (IsKeyPressed.class) {
                    switch (ke.getID()) {
                        case KeyEvent.KEY_PRESSED:
                       if(ke.getKeyCode() == KeyEvent.VK_W){
                           System.out.println("PRESS W");
                       }
                        case KeyEvent.KEY_RELEASED:
                            if (ke.getKeyCode() == KeyEvent.VK_W) {

                            }
                    }
                }

                return false;
            }
        });
    }

    public class IsKeyPressed {
        private static volatile boolean wPressed = false;

        public static boolean isWPressed() {
            synchronized (IsKeyPressed.class) {
                return wPressed;
            }
        }
    }
}
