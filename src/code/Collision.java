package code;

import java.io.IOException;
import java.util.ArrayList;

public class Collision {


    private Player player;
    private Level level;
    private ArrayList<Target> targets;

    public Collision(Level level) {
        this.level = level;
        this.player = level.getPlayer();
        this.targets = level.getTargets();
    }


    public boolean checkWallCollision(Figure figure, char direction) {


        switch (direction) {

            case 'l':

                for (int i = 0; i < level.getWalls().size(); i++) {

                    Wall wall = level.getWalls().get(i);

                    if (figure.isLeftCollision(wall)) {

                        return true;
                    }
                }

                return false;

            case 'r':

                for (int i = 0; i < level.getWalls().size(); i++) {

                    Wall wall = level.getWalls().get(i);

                    if (figure.isRightCollision(wall)) {

                        return true;
                    }
                }

                return false;

            case 'u':

                for (int i = 0; i < level.getWalls().size(); i++) {

                    Wall wall = level.getWalls().get(i);

                    if (figure.isTopCollision(wall)) {

                        return true;
                    }
                }

                return false;

            case 'd':

                for (int i = 0; i < level.getWalls().size(); i++) {

                    Wall wall = level.getWalls().get(i);

                    if (figure.isBottomCollision(wall)) {

                        return true;
                    }
                }

                return false;
        }

        return false;
    }

    public boolean checkBoxCollision(char direction) {


        switch (direction) {

            case 'l':

                for (int i = 0; i < level.getBoxes().size(); i++) {

                    Box box = level.getBoxes().get(i);

                    if (player.isLeftCollision(box)) {

                        for (int j = 0; j < level.getBoxes().size(); j++) {

                            Box box2 = level.getBoxes().get(j);

                            if (!box.equals(box2)) {

                                if (box.isLeftCollision(box2)) {
                                    return true;
                                }
                            }
                            if (checkWallCollision(box,'l')) {
                                return true;
                            }

                        }
                        box.move(-level.SPACE, 0);
                        if(checkTargetCollision(box)) {
                            box.onTarget();
                        } else box.notOnTarget();

                    }
                }

                return false;

            case 'r':

                for (int i = 0; i < level.getBoxes().size(); i++) {

                    Box box = level.getBoxes().get(i);

                    if (player.isRightCollision(box)) {

                        for (int j = 0; j < level.getBoxes().size(); j++) {

                            Box box2 = level.getBoxes().get(j);

                            if (!box.equals(box2)) {

                                if (box.isRightCollision(box2)) {
                                    return true;
                                }
                            }
                            if (checkWallCollision(box,'r')) {
                                return true;
                            }

                        }
                        box.move(level.SPACE, 0);
                        if(checkTargetCollision(box)) {
                            box.onTarget();
                        } else box.notOnTarget();

                    }
                }

                return false;

            case 'u':

                for (int i = 0; i < level.getBoxes().size(); i++) {

                    Box box = level.getBoxes().get(i);

                    if (player.isTopCollision(box)) {

                        for (int j = 0; j < level.getBoxes().size(); j++) {

                            Box box2 = level.getBoxes().get(j);

                            if (!box.equals(box2)) {

                                if (box.isTopCollision(box2)) {
                                    return true;
                                }
                            }
                            if (checkWallCollision(box,'u')) {
                                return true;
                            }

                        }
                        box.move(0, -level.SPACE);
                        if(checkTargetCollision(box)) {
                            box.onTarget();
                        } else box.notOnTarget();
                    }
                }

                return false;

            case 'd':

                for (int i = 0; i < level.getBoxes().size(); i++) {

                    Box box = level.getBoxes().get(i);


                    if (player.isBottomCollision(box)) {

                        for (int j = 0; j < level.getBoxes().size(); j++) {

                            Box box2 = level.getBoxes().get(j);

                            if (!box.equals(box2)) {

                                if (box.isBottomCollision(box2)) {
                                    return true;
                                }
                            }
                            if (checkWallCollision(box,'d')) {
                                return true;
                            }

                        }

                        box.move(0, level.SPACE);

                        if(checkTargetCollision(box)) {
                            box.onTarget();
                        } else box.notOnTarget();

                    }
                }
        }

        return false;

    }

    public boolean checkTargetCollision(Box box ) {

        for (int i = 0; i < targets.size(); i++) {

            Target target = targets.get(i);

            if (box.getX() == target.getX() && box.getY() == target.getY()) {
                return true;
            }
        } return false;

    }


}


