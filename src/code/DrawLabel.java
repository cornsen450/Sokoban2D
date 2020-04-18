package code;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class DrawLabel extends JLabel {

    private Level lvl;
    private static final long serialVersionUID = 1L;

    public DrawLabel(Level lvl) {
        this.lvl = lvl;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //Set color of background an draw it
        g.setColor(new Color(50, 50, 50));
        g.fillRect(0, 0, lvl.getLevelWidth()+lvl.SPACE, lvl.getLevelHeight()+lvl.OFFSET);

        //draw Steps and Targets
        g.setColor(Color.WHITE);
        g.drawString("Steps: " + lvl.getSteps(),32,16);
        //g.drawString("Targets: " + lvl.getFinishedTargets() + "/" + lvl.getTargets().size(),128,16);
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
    }

}
