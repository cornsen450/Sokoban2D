package code;

import javax.swing.*;
import java.awt.*;

public class Wall extends Figure {



    public Wall(int x, int y) {
        super(x, y);
        initWall();
    }

    private void initWall() {
        ImageIcon i = new ImageIcon("src/graphics/wall.png");
        Image image = i.getImage();
        setImage(image);
    }
}

