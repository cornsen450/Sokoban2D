package code;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch(key) {

            case KeyEvent.VK_UP:

                //Collision check with Right Object
                //Player move up
            default:
                break;
        }
    }
}
