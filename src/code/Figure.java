package code;

import java.awt.*;

public abstract class Figure {



    private int x;
    private int y;
    private Image image;
    public final int SPACE = 64;

    public Figure (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image img) {
        image = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLeftCollision(Figure figure) {

        return getX() - SPACE == figure.getX() && getY() == figure.getY();
    }

    public boolean isRightCollision(Figure figure) {

        return getX() + SPACE == figure.getX() && getY() == figure.getY();
    }

    public boolean isTopCollision(Figure figure) {

        return getY() - SPACE == figure.getY() && getX() == figure.getX();
    }

    public boolean isBottomCollision(Figure figure) {

        return getY() + SPACE == figure.getY() && getX() == figure.getX();
    }
}
