package code;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class DrawLabel extends JLabel {

    private Level lvl;
    private static final long serialVersionUID = 1L;

    public DrawLabel(Level lvl) {
        this.lvl = lvl;
    }
    public void setLvl(Level lvl) {
        this.lvl = lvl;
    }

    public void paintComponent(Graphics g) {
        ImageIcon im = new ImageIcon("src/graphics/groundhell.png");
        Image imageGround = im.getImage();


        super.paintComponent(g);

        g.setColor(new Color(220, 220, 220));
        g.fillRect(0, 0, lvl.getLevelWidth()+lvl.SPACE, lvl.getLevelHeight()+lvl.OFFSET);



        //Paint Ground
        for (int i = 0; i < lvl.getLevelWidth(); i += lvl.SPACE) {
            for (int j = 0; j < lvl.getLevelHeight(); j += lvl.SPACE) {
                g.drawImage(imageGround,i,j+24,this);
            }
        }

        //draw Steps and Targets
        g.setColor(Color.BLACK);
        g.drawString("Steps: " + lvl.getSteps(),32,16);
        //draw Player+Walls+Boxes+Targets
        ArrayList<Object> world = new ArrayList<Object>();
        world.addAll(lvl.getWalls());
        world.addAll(lvl.getTargets());
        world.addAll(lvl.getBoxes());
        world.add(lvl.getPlayer());


        for (int i = 0; i < world.size(); i++) {

            Figure item = (Figure) world.get(i);


            g.drawImage(item.getImage(), item.getX() , item.getY() , this);


        }
        //Check for Win
        if (lvl.checkWin() == true){
            g.setColor(Color.RED);
            g.drawString("solved", 128, 16);

            g.drawString("----- >  Press Enter for next Level", 196, 16);

        }
        if (lvl.checkWin() == false){
            g.setColor(Color.BLACK);
            g.drawString("unsolved", 128, 16);
        }


    }

}
