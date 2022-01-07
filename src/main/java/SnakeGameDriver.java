import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.prefs.Preferences;

public class SnakeGameDriver {

    static int stepCount= 0;
    static int snakeIdx = 0;
    static Point[] snakePositions = new Point[3];

    @SuppressWarnings( "resource" )
    public static void main( String[] args ) {

        Point playerPosition = Player.getPlayerPosition();

        // Point[] snakePositions = Snake.getSnakePositions();
        // int snakeIdx = Snake.getSnakeIdx();


        // Level 1 Elemente
        Point[] levelOneElements = Level_1_Elements.getLevelOneElements();
        snakePositions[snakeIdx] = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));

        // Level 2 Elemente
        Point[] levelTwoElements = Level_2_Elements.getLevelTwoElements();

        // Level 3 Elemente
        Point[] levelThreeElements = Level_3_Elements.getLevelThreeElements();


        boolean rich = false;
        int level = 1;
        int achievedPoints = 0;
        // int stepCount = Player.getStepCount();
        int potionCount = 0;
        int shieldCount = 0;
        boolean potionActive = false;
        boolean shieldActive = false;
        boolean swordActive = false;
        boolean boardActive = false;

        // Wird benötigt, um Highscore zu speichern
        Preferences pref = Preferences.userNodeForPackage(SnakeGameDriver.class);
        final String item1 = "item1";



        while (true) {

            Point snakeHead = new Point ((int) (Math.random()*59),(int) (Math.random()*9) );
            Snake.addSnakeMovement();

            if (level == 1) {
                BoardLevel.drawLevelOne(playerPosition, levelOneElements[0],
                        levelOneElements[1], snakePositions,levelOneElements[4], levelOneElements[2], levelOneElements[3],
                         levelOneElements[5]);
            }


            if (level == 2) {

                BoardLevel.drawLevelTwo(playerPosition, Level_2_Elements.getGoldPositions(),levelTwoElements[2],
                        snakePositions ,levelTwoElements[3], levelTwoElements[4], levelTwoElements[5],
                        levelTwoElements[6]);

                if (playerPosition.equals(levelTwoElements[0])) {
                    ++achievedPoints;
                    rich = true;
                    levelTwoElements[0].setLocation(-1, -1); //Wenn Gold eingesammelt wurde, wird es vom Feld entfernt
                }
                if (playerPosition.equals(levelTwoElements[1])) {
                    ++achievedPoints;
                    rich = true;
                    levelTwoElements[1].setLocation(-1, -1);
                }
            }


            if (level == 3) {

                BoardLevel.drawLevelThree(playerPosition, Level_3_Elements.getGoldPositions(), levelThreeElements[3],
                        snakePositions, levelThreeElements[6], levelThreeElements[4],
                        levelThreeElements[5], levelThreeElements[7]);

                if (playerPosition.equals(levelThreeElements[0])) {
                    ++achievedPoints;
                    rich = true;
                    levelThreeElements[0].setLocation(-1, -1);
                }
                if (playerPosition.equals(levelThreeElements[1])) {
                    ++achievedPoints;
                    rich = true;
                    levelThreeElements[1].setLocation(-1, -1);
                }
                if (playerPosition.equals(levelThreeElements[2])) {
                    ++achievedPoints;
                    rich = true;
                    levelThreeElements[2].setLocation(-1, -1);
                }
            }

            // Zusätzliche Informationen

            System.out.println("Level: " + level);
            System.out.println("Current score: " + achievedPoints);
            System.out.println("Highscore: " + pref.getInt(item1, 0));
            System.out.println("Elements: & = player, S = snake, $ = gold, # = door, D = springboard, " +
                    "Y = magic potion, O = shield, V = sword");
            System.out.println("Movement: l = go left, r = go right, h = go up, t = go down");
            System.out.println("magic potion: " + potionActive + ", shield: " + shieldActive +
                    ", sword: " + swordActive + ", springboard: " + boardActive + ", rich: " + rich);

            // Status feststellen -> collision detection

            if ((level == 1 && rich && playerPosition.equals(levelOneElements[1])) ||
                    (level == 2 && rich && playerPosition.equals(levelTwoElements[2]))) {
                stepCount = 0;
                potionCount = 0;
                shieldCount = 0;
                potionActive = false;
                shieldActive = false;
                swordActive = false;
                boardActive = false;
                rich = false;
                level++;
            }

            if (level == 3 && rich && playerPosition.equals(levelThreeElements[3])) {
                if (achievedPoints > pref.getInt(item1, 0)) {
                    pref.putInt(item1, achievedPoints);
                }
                System.out.println("Gewonnen!");
                return;
            }

            if (playerPosition.equals(levelOneElements[3])) {
                shieldActive = true;
                levelOneElements[3].setLocation(-5, -5);
            }

            if (playerPosition.equals(levelTwoElements[4])) {
                shieldActive = true;
                levelTwoElements[4].setLocation(-5, -5);
            }

            if (playerPosition.equals(levelThreeElements[5])) {
                shieldActive = true;
                levelThreeElements[5].setLocation(-5, -5);
            }

            if (playerPosition.equals(levelOneElements[2])) {
                potionActive = true;
                levelOneElements[2].setLocation(-2, -3);
            }

            if (playerPosition.equals(levelTwoElements[3])) {
                potionActive = true;
                levelTwoElements[3].setLocation(-2, -3);
            }

            if (playerPosition.equals(levelThreeElements[4])) {
                potionActive = true;
                levelThreeElements[4].setLocation(-2, -3);
            }

            if (playerPosition.equals(levelOneElements[4]) || playerPosition.equals(levelTwoElements[5])
                    || playerPosition.equals(levelThreeElements[6])) {
                boardActive = true;
            }

            if (playerPosition.equals(levelOneElements[5])) {
                swordActive = true;
                levelOneElements[5].setLocation(-6, -7);
            }

            if (playerPosition.equals(levelTwoElements[6])) {
                swordActive = true;
                levelTwoElements[6].setLocation(-6, -7);
            }

            if (playerPosition.equals(levelThreeElements[7])) {
                swordActive = true;
                levelThreeElements[7].setLocation(-6, -7);
            }

            if (Arrays.asList(snakePositions).contains(playerPosition)) {
                if (shieldCount == 5) {
                    shieldActive = false;
                } else if (swordActive) {
                    snakeHead.setLocation(-10, -10);
                } else {
                    System.out.println("ZZZZZZZ. Die Schlange hat dich!");
                    return;
                }
            }

            if (playerPosition.equals(levelOneElements[0])) {
                ++achievedPoints;
                rich = true;
                levelOneElements[0].setLocation(-1, -1);
            }

            // Konsolen-Eingabe und Spielerposition verändern → gehört in Player.java

            switch (new Scanner(System.in).next()) {

                case "w":
                    stepCount++;
                    shieldCount++;
                    if (potionActive) {
                        potionCount++;
                        playerPosition.y = Math.max(0, playerPosition.y - 2);
                        if (potionCount == 5) {
                            potionActive = false;
                        }
                    } else if (boardActive) {
                        playerPosition.y = Math.max(0, playerPosition.y - 5);
                        boardActive = false;
                    } else {
                        playerPosition.y = Math.max(0, playerPosition.y - 1);
                    }
                    break;

                case "s":
                    stepCount++;
                    shieldCount++;
                    if (potionActive) {
                        potionCount++;
                        playerPosition.y = Math.max(0, playerPosition.y + 2);
                        if (potionCount == 5) {
                            potionActive = false;
                        }
                    } else if (boardActive) {
                        playerPosition.y = Math.max(0, playerPosition.y + 5);
                        boardActive = false;
                    } else {
                        if (level == 1) {
                            playerPosition.y = Math.min(9, playerPosition.y + 1);
                        } else if (level == 2 || level == 3) {
                            playerPosition.y = Math.min(14, playerPosition.y + 1);
                        }
                    }
                    break;

                case "a":
                    stepCount++;
                    shieldCount++;
                    if (potionActive) {
                        potionCount++;
                        playerPosition.x = Math.max(0, playerPosition.x - 2);
                        if (potionCount == 5) {
                            potionActive = false;
                        }
                    } else if (boardActive) {
                        playerPosition.x = Math.max(0, playerPosition.x - 8);
                        boardActive = false;
                    } else {
                        playerPosition.x = Math.max(0, playerPosition.x - 1);
                    }
                    break;

                case "d":
                    stepCount++;
                    shieldCount++;
                    if (potionActive) {
                        potionCount++;
                        playerPosition.x = Math.max(0, playerPosition.x + 2);
                        if (potionCount == 5) {
                            potionActive = false;
                        }
                    } else if (boardActive) {
                        playerPosition.x = Math.max(0, playerPosition.x + 8);
                        boardActive = false;
                    } else {
                        if (level == 1) {
                            playerPosition.x = Math.min(59, playerPosition.x + 1);
                        } else if (level == 2) {
                            playerPosition.x = Math.min(69, playerPosition.x + 1);
                        } else if (level == 3) {
                            playerPosition.x = Math.min(79, playerPosition.x + 1);
                        }
                    }
                    break;
            }
            // Snake.addSnakeMovement();
            }
        }
    }


