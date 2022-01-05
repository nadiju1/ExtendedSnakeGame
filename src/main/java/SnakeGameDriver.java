import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.prefs.Preferences;

public class SnakeGameDriver {

    @SuppressWarnings( "resource" )
    public static void main( String[] args ) {

        // Level 1 Elemente
        Point playerPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point goldPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point doorPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point magicPotionPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point shieldPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point springboardPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point swordPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point[] snakePositions = new Point[3];
        int snakeIdx = 0;
        snakePositions[snakeIdx] = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));

        // Level 2 Elemente
        Point doorPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point[] goldPositions = new Point[2];
        goldPositions[0] = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        goldPositions[1] = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point magicPotionPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point shieldPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point springboardPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point swordPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));

        //Level 3 Elemente
        Point doorPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point[] goldPositions2 = new Point[3];
        goldPositions2[0] = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        goldPositions2[1] = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        goldPositions2[2] = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point magicPotionPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point shieldPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point springboardPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point swordPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));

        boolean rich = false;
        int level = 1;
        int achievedPoints = 0;
        int stepCount = 0;
        int potionCount = 0;
        int shieldCount = 0;
        boolean potionActive = false;
        boolean shieldActive = false;
        boolean swordActive = false;
        boolean boardActive = false;

        // Wird benötigt um Highscore zu speichern
        Preferences pref = Preferences.userNodeForPackage(SnakeGameDriver.class);
        final String item1 = "item1";

        while (true) {

            Point snakeHead = new Point(snakePositions[snakeIdx].x, snakePositions[snakeIdx].y);

            if (level == 1) {
                BoardLevel.drawLevelOne(playerPosition, goldPosition, doorPosition,
                        snakePositions, springboardPosition, magicPotionPosition,
                        shieldPosition, swordPosition);
            }

            if (level == 2) {

                BoardLevel.drawLevelTwo(playerPosition, goldPositions, doorPosition2,
                        snakePositions, springboardPosition2, magicPotionPosition2,
                        shieldPosition2, swordPosition2);

                if (playerPosition.equals(goldPositions[0])) {
                    ++achievedPoints;
                    rich = true;
                    goldPositions[0].setLocation(-1, -1);
                }
                if (playerPosition.equals(goldPositions[1])) {
                    ++achievedPoints;
                    rich = true;
                    goldPositions[1].setLocation(-1, -1);
                }
            }

            if (level == 3) {

                BoardLevel.drawLevelThree(playerPosition, goldPositions2, doorPosition3,
                        snakePositions, springboardPosition3, magicPotionPosition3,
                        shieldPosition3, swordPosition3);

                if (playerPosition.equals(goldPositions2[0])) {
                    ++achievedPoints;
                    rich = true;
                    goldPositions2[0].setLocation(-1, -1);
                }
                if (playerPosition.equals(goldPositions2[1])) {
                    ++achievedPoints;
                    rich = true;
                    goldPositions2[1].setLocation(-1, -1);
                }
                if (playerPosition.equals(goldPositions2[2])) {
                    ++achievedPoints;
                    rich = true;
                    goldPositions2[2].setLocation(-1, -1);
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

            if ((level == 1 && rich && playerPosition.equals(doorPosition)) ||
                    (level == 2 && rich && playerPosition.equals(doorPosition2))) {
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

            if (level == 3 && rich && playerPosition.equals(doorPosition3)) {
                if (achievedPoints > pref.getInt(item1, 0)) {
                    pref.putInt(item1, achievedPoints);
                }
                System.out.println("Gewonnen!");
                return;
            }

            if (playerPosition.equals(shieldPosition)) {
                shieldActive = true;
                shieldPosition.setLocation(-5, -5);
            }

            if (playerPosition.equals(shieldPosition2)) {
                shieldActive = true;
                shieldPosition2.setLocation(-5, -5);
            }

            if (playerPosition.equals(shieldPosition3)) {
                shieldActive = true;
                shieldPosition3.setLocation(-5, -5);
            }

            if (playerPosition.equals(magicPotionPosition)) {
                potionActive = true;
                magicPotionPosition.setLocation(-2, -3);
            }

            if (playerPosition.equals(magicPotionPosition2)) {
                potionActive = true;
                magicPotionPosition2.setLocation(-2, -3);
            }

            if (playerPosition.equals(magicPotionPosition3)) {
                potionActive = true;
                magicPotionPosition3.setLocation(-2, -3);
            }

            if (playerPosition.equals(springboardPosition) || playerPosition.equals(springboardPosition2)
                    || playerPosition.equals(springboardPosition3)) {
                boardActive = true;
            }

            if (playerPosition.equals(swordPosition)) {
                swordActive = true;
                swordPosition.setLocation(-6, -7);
            }

            if (playerPosition.equals(swordPosition2)) {
                swordActive = true;
                swordPosition2.setLocation(-6, -7);
            }

            if (playerPosition.equals(swordPosition3)) {
                swordActive = true;
                swordPosition3.setLocation(-6, -7);
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

            if (playerPosition.equals(goldPosition)) {
                ++achievedPoints;
                rich = true;
                goldPosition.setLocation(-1, -1);
            }

            if (playerPosition.equals(goldPositions[0])) {
                ++achievedPoints;
                rich = true;
                goldPositions[0].setLocation(-1, -1);
            }

            if (playerPosition.equals(goldPositions[1])) {
                ++achievedPoints;
                rich = true;
                goldPositions[1].setLocation(-1, -1);
            }

            if (playerPosition.equals(goldPositions2[0])) {
                ++achievedPoints;
                rich = true;
                goldPositions2[0].setLocation(-1, -1);
            }

            if (playerPosition.equals(goldPositions2[1])) {
                ++achievedPoints;
                rich = true;
                goldPositions2[1].setLocation(-1, -1);
            }

            if (playerPosition.equals(goldPositions2[2])) {
                ++achievedPoints;
                rich = true;
                goldPositions2[2].setLocation(-1, -1);
            }

            // Konsoleneingabe und Spielerposition verändern

            switch (new Scanner(System.in).next()) {

                case "h":
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

                case "t":
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

                case "l":
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

                case "r":
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

            // Schlange bewegt sich Richtung Spieler

                if (stepCount > 15) {
                    if (playerPosition.x < snakeHead.x)
                        snakeHead.x--;
                    else if (playerPosition.x > snakeHead.x)
                        snakeHead.x++;
                    if (playerPosition.y < snakeHead.y)
                        snakeHead.y--;
                    else if (playerPosition.y > snakeHead.y)
                        snakeHead.y++;

                    snakeIdx = (snakeIdx + 1) % snakePositions.length;
                    snakePositions[snakeIdx] = snakeHead;
                }
            }
        }
    }


