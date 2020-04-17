package code;

import java.awt.event.KeyAdapter;
import java.util.ArrayList;


public class Level {

    private final int OFFSET = 30;
    private final int SPACE = 20;

    private ArrayList<Wall> walls;
    private ArrayList<Box> boxes;
    private ArrayList<Target> targets;

    private Player player;
    private KeyListener keyListener;




    public Level() {
        initLevel();
    }

    public void initLevel() {
        KeyListener keyListener = new KeyListener();
        Draw draw = new Draw();

        //Level einlesen
        initWorld();
    }

    public void initWorld() {
        walls = new ArrayList<>();
        boxes = new ArrayList<>();
        targets = new ArrayList<>();



    }


}
