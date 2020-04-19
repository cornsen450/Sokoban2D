package code;

import javax.swing.*;
import java.awt.*;

public class Box extends Figure{

    private boolean solved = false;

    public Box(int x, int y) {
        super(x, y);
        initBox();
    }

    private void initBox() {

        ImageIcon i = new ImageIcon("src/graphics/box.png");
        Image image = i.getImage();
        setImage(image);
    }

    public void onTarget() {
        ImageIcon i = new ImageIcon("src/graphics/boxTarget.png");
        Image image = i.getImage();
        setImage(image);
        this.solved = true;
    }

    public void notOnTarget() {
        ImageIcon i = new ImageIcon("src/graphics/box.png");
        Image image = i.getImage();
        setImage(image);
        this.solved = false;
    }



    public void move(int x, int y) {

        int dx = getX() + x;
        int dy = getY() + y;

        setX(dx);
        setY(dy);
    }

    public boolean isSolved() {
        return solved;
    }

}
