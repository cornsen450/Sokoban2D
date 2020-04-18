package code;

import javax.swing.*;
import java.awt.*;

public class Player extends Figure {

    public Player(int x, int y) {
        super(x, y);

        initPlayer();
    }

    private void initPlayer() {
        ImageIcon i = new ImageIcon("src/graphics/player.png");
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
