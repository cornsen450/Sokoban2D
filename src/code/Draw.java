package code;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;


public class Draw extends JLabel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(250, 240, 170));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());






    }
    
}
