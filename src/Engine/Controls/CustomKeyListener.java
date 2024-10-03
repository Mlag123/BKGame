package Engine.Controls;

import Engine.Key;
import Entity.Player;
import Math.GameObjects.GameObjectIsNull;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomKeyListener extends KeyAdapter {
    Player player;

    public CustomKeyListener(Player player) {
        this.player = player;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // current_key = "stop";
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();


        if (keyCode == KeyEvent.VK_W) {
            player.moveUP();
        } else if (keyCode == KeyEvent.VK_S) {
            try {
                player.moveDown();
            } catch (GameObjectIsNull ex) {
                throw new RuntimeException(ex);
            }
        } else if (keyCode == KeyEvent.VK_A) {
            player.moveLeft();
        } else if (keyCode == KeyEvent.VK_D) {
            player.moveRight();
        } else if (keyCode == KeyEvent.VK_W && keyCode == KeyEvent.VK_A) {
            player.moveUP();
            player.moveLeft();
        } else if (keyCode == KeyEvent.VK_W && keyCode == KeyEvent.VK_D) {
            try {
                player.moveDown();
            } catch (GameObjectIsNull ex) {
                throw new RuntimeException(ex);
            }
        }else if(keyCode == KeyEvent.VK_R){
            player.restart_player();
            System.out.println("sbros");
        }


    }
}
