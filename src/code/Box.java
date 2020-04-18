package code;

import javax.swing.*;
import java.awt.*;

public class Box extends Figure{

    public Box(int x, int y) {
        super(x, y);

        initBox();
    }

    private void initBox() {

        ImageIcon i = new ImageIcon("src/graphics/box.png");
        Image image = i.getImage();
        setImage(image);
    }

    public void move(int x, int y) {

        int dx = getX() + x;
        int dy = getY() + y;

        setX(dx);
        setY(dy);
    }
}
