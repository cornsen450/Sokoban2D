package code;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;


public class Level {

    public final int OFFSET = 32;
    public final int SPACE = 64;


    private ArrayList<Figure> world;
    public ArrayList<Wall> walls;
    private ArrayList<Box> boxes;
    private ArrayList<Target> targets;
    private Player player;
    private DrawFrame drawFrame;

    private int steps = 0;
    private int finishedTargets = 0;

    private int width = 0;
    private int height = 0;


    public Level() throws IOException {
        initLevel();
        DrawFrame drawFrame = new DrawFrame(this);
        this.drawFrame = drawFrame;
    }

    public int getLevelWidth() {
        return this.width;
    }

    public int getLevelHeight() {
        return this.height;
    }

    public ArrayList<Target> getTargets() { return this.targets; }
    public ArrayList<Box> getBoxes() { return this.boxes; }
    public ArrayList<Wall> getWalls() { return this.walls; }
    public Player getPlayer() { return this.player; }

    public void initLevel() throws IOException {

        world = new ArrayList<>();

        walls = new ArrayList<>();
        boxes = new ArrayList<>();
        targets = new ArrayList<>();

        LevelReader levelReader = new LevelReader("lvl1.txt");


        Wall wall;
        Box box;
        Target target;

        char[][] lvl = levelReader.getMapArray();


        int x = OFFSET;
        int y = OFFSET;

        for(int i = 0; i < lvl.length; i++){
            for(int j = 0; j< lvl[i].length; j++){
                switch(lvl[i][j]) {
                    case ('@'):
                        player = new Player(x,y);
                        x += SPACE;
                        break;
                    case('#'):
                        wall = new Wall(x,y);
                        walls.add(wall);
                        x += SPACE;
                        break;
                    case('$'):
                        box = new Box(x,y);
                        boxes.add(box);
                        x += SPACE;
                        break;
                    case('.'):
                        target = new Target(x,y);
                        targets.add(target);
                        x += SPACE;
                        break;
                    case(' '):
                        x += SPACE;
                        break;
                    default:
                        break;
                }

                if (j == lvl[i].length-1) {
                    y += SPACE;

                    if (this.width < x) {
                        this.width = x;
                    }

                    x = OFFSET;
                }


            } height = y;

            world.add(player);
            world.addAll(walls);
            world.addAll(boxes);
            world.addAll(targets);



        }

    }

    public void restartLevel() throws IOException {
        world.clear();
        walls.clear();
        targets.clear();
        walls.clear();
        this.steps = 0;
        this.finishedTargets = 0;
        initLevel();
        //Wird nur einmal geschlossen?=!
        drawFrame.dispose();
        DrawFrame drawFrame = new DrawFrame(this);
        this.drawFrame = drawFrame;


    }


    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = this.steps + steps;
    }

    public int getFinishedTargets() {
        return finishedTargets;
    }

    public void setFinishedTargets(int finishedTargets) {
        this.finishedTargets = finishedTargets;
    }
}
