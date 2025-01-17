package Engine.Controls;

import Entity.Player;
import Utils.Exceptions.GameObjectIsNull;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CustomKeyListener implements  Runnable{
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
                            if (ke.getKeyCode() == KeyEvent.VK_W) {
                                player.moveUP();
                                System.out.printf("w");

                            }else if(ke.getKeyCode() == KeyEvent.VK_S){
                                try {
                                    player.moveDown();
                                } catch (GameObjectIsNull e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (ke.getKeyCode() == KeyEvent.VK_A) {
                                player.moveLeft();
                            } else if (ke.getKeyCode() == KeyEvent.VK_D) {
                                try {
                                    player.moveRight();
                                } catch (GameObjectIsNull e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (ke.getKeyCode()==KeyEvent.VK_R) {
                                player.restart_player();

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
