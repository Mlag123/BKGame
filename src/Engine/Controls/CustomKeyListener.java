package Engine.Controls;

import Entity.AbstractEntity;
import Entity.Player;
import Utils.Exceptions.GameObjectIsNull;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CustomKeyListener implements  Runnable{
   //private AbstractEntity entity;

    private Player player;

    public CustomKeyListener(Player player) {
this.player = player;


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
                           player.moveUP();
                       }
                       if (ke.getKeyCode()==KeyEvent.VK_A){
                           try {
                               player.moveLeft();
                           } catch (GameObjectIsNull e) {
                               throw new RuntimeException(e);
                           }
                       }
                       if (ke.getKeyCode()== KeyEvent.VK_D){
                           try {
                               player.moveRight();
                           } catch (GameObjectIsNull e) {
                               throw new RuntimeException(e);
                           }
                       }
                       if (ke.getKeyCode() == KeyEvent.VK_S){
                           try {
                               player.moveDown();
                           } catch (GameObjectIsNull e) {
                               throw new RuntimeException(e);
                           }
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
