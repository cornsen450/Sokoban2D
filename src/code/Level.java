package code;

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
    private DrawLabel drawLabel;

    public int lvldata = 1;

    private int steps = 0;;
    private int solved = 0;

    private int width = 0;
    private int height = 0;


    public Level(int lvldata) throws IOException {
        this.lvldata = lvldata;
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

        LevelReader levelReader = new LevelReader("lvl"+lvldata+".txt");


        Wall wall;
        Box box;
        Target target;

        char[][] lvl = levelReader.getMapArray();


        int x = OFFSET;
        int y = OFFSET;

        for(int i = 0; i < lvl.length; i++){
            for(int j = 0; j< lvl[i].length; j++){
                switch(lvl[i][j]) {
                    case ('*'):
                        target = new Target(x,y);
                        box = new Box(x,y);
                        box.onTarget();
                        targets.add(target);
                        boxes.add(box);

                        x += SPACE;
                        break;
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
        drawFrame.dispose();
        Level level = new Level(lvldata);

    }


    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = this.steps + steps;
    }

    public boolean checkWin() {

        int w = 0;

        for (int i = 0; i < boxes.size(); i++) {
            Box box = boxes.get(i);
            if (box.isSolved() == true) {
                w += 1;
            }
        }
        if (w == targets.size()) {
            return true;
        }else return false;

    }

    public void nextLevel() throws IOException {
        lvldata += 1;
        restartLevel();

    }


}