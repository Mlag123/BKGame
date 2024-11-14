package Engine.Controls;

import Engine.Key;
import Engine.PanelGame;
import Entity.Player;
import Math.GameObjects.GameObjectIsNull;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomKeyListener {
    Player player;


    public CustomKeyListener(Player player) {
        this.player = player;

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (IsKeyPressed.class) {
                    switch (ke.getID()) {
                        case KeyEvent.KEY_PRESSED:
                            if (ke.getKeyCode() == KeyEvent.VK_W) {
                                    player.moveUP();

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
