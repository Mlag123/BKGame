package Engine.Controls;

import Entity.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomKeyListener extends KeyAdapter {
Player player;

    public CustomKeyListener(Player player){
        this.player = player;
    }
    @Override
    public void keyReleased(KeyEvent e) {
      // current_key = "stop";
    }
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                player.moveUP();
                break;
            case KeyEvent.VK_S:
                player.moveDown();
                 break;
            case KeyEvent.VK_A:
                player.moveLeft();
                break;
            case KeyEvent.VK_D:
                player.moveRight();
                break;
            default:
        }
    }
}
