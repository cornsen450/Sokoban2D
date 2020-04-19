package code;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.awt.event.KeyEvent;


public class DrawFrame extends JFrame implements KeyListener {

    private static final long serialVersionUID = 11L;


    private DrawLabel drawLabel;
    private Collision collision;
    private Level lvl;



    public DrawFrame(Level lvl) throws IOException {
        Collision collision = new Collision(lvl);
        this.collision = collision;
        this.lvl = lvl;
        addKeyListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        setResizable(false);
        setSize(this.lvl.getLevelWidth()+lvl.OFFSET,this.lvl.getLevelHeight()+lvl.SPACE);
        setLocationRelativeTo(null);
        setTitle("Sokoban Level " + lvl.lvldata);
        drawLabel = new DrawLabel(lvl);
        drawLabel.setBounds(0,0,lvl.getLevelWidth(),lvl.getLevelHeight());
        add(drawLabel);
        setVisible(true);
    }




    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (lvl.checkWin() == true) {
            return;
        }

        int key = e.getKeyCode();

        switch (key) {

            case KeyEvent.VK_LEFT:
                if(collision.checkWallCollision(lvl.getPlayer(),'l')) {
                    break;
                }
                if(collision.checkBoxCollision('l')) {
                    break;
                }

                lvl.getPlayer().move(-lvl.SPACE,0);
                lvl.setSteps(1);
                break;

            case KeyEvent.VK_RIGHT:
                if(collision.checkWallCollision(lvl.getPlayer(),'r')) {
                    break;
                }
                if(collision.checkBoxCollision('r')) {
                    break;
                }
                lvl.getPlayer().move(lvl.SPACE,0);
                lvl.setSteps(1);
                break;

            case KeyEvent.VK_UP:
                if(collision.checkWallCollision(lvl.getPlayer(),'u')) {
                    break;
                }
                if(collision.checkBoxCollision('u')) {
                    break;
                }
                lvl.getPlayer().move(0, -lvl.SPACE);
                lvl.setSteps(1);
                break;

            case KeyEvent.VK_DOWN:
                if(collision.checkWallCollision(lvl.getPlayer(),'d')) {
                    break;
                }
                if(collision.checkBoxCollision('d')) {
                    break;
                }
                lvl.getPlayer().move(0, lvl.SPACE);
                lvl.setSteps(1);

                break;


            default:
                break;
        }

        repaint();




    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        switch (key) {

            case KeyEvent.VK_R:
                try {
                    lvl.restartLevel();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                break;
        }

        switch (key) {

            case KeyEvent.VK_ENTER:
                if (lvl.checkWin() == true) {
                    try {
                        lvl.nextLevel();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

                break;
        }



    }


}
