package code;

import javax.swing.*;
import java.awt.*;

public class Target extends Figure{

    public Target(int x, int y) {
        super(x, y);

        initTarget();
    }

    private void initTarget() {

        ImageIcon i = new ImageIcon("src/graphics/target.png");
        Image image = i.getImage();
        setImage(image);
    }

}
