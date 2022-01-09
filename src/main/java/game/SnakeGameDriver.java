package game;

import java.awt.*;
import java.util.Arrays;
import java.util.prefs.Preferences;

public class SnakeGameDriver {

    static int stepCount = 0;
    static int shieldCount = 0;
    static int level = 1;
    static int achievedPoints = 0;
    static int potionCount = 0;
    static boolean potionActive = false;
    static boolean shieldActive = false;
    static boolean swordActive = false;
    static boolean springboardActive = false;
    static String snakeAsleep = "Snake is still asleep...";
    static String snakeAwake = "Watch out, Snake is awake!";

    @SuppressWarnings( "resource" )
    public static void main( String[] args ) {

        // Level 1 Elemente
        Point goldPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point doorPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point magicPotionPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point shieldPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point springboardPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point swordPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Player player = new Player();
        Snake snake = new Snake ();

        // Level 2 Elemente
        Point doorPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point[] goldPositions = new Point[2];
        goldPositions[0] = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        goldPositions[1] = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point magicPotionPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point shieldPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point springboardPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point swordPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));

        // Level 3 Elemente
        Point doorPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point[] goldPositions2 = new Point[3];
        goldPositions2[0] = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        goldPositions2[1] = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        goldPositions2[2] = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point magicPotionPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point shieldPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point springboardPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point swordPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));

        boolean rich = false; // man braucht alle Golstücke für true

        // Wird benötigt um Highscore zu speichern
        Preferences pref = Preferences.userNodeForPackage(SnakeGameDriver.class);
        final String item1 = "item1";

        while (true) {

            if (level == 1) {
                BoardLevel.drawLevelOne(player.position, goldPosition, doorPosition,
                        snake.positions, springboardPosition, magicPotionPosition,
                        shieldPosition, swordPosition);

                if (player.position.equals(goldPosition)) {
                    ++achievedPoints;
                    rich = true;
                    goldPosition.setLocation(-10, -10);
                }
            }

            if (level == 2) {

                BoardLevel.drawLevelTwo(player.position, goldPositions, doorPosition2,
                        snake.positions, springboardPosition2, magicPotionPosition2,
                        shieldPosition2, swordPosition2);

                if (player.position.equals(goldPositions[0])) {
                    ++achievedPoints;
                    goldPositions[0].setLocation(-10, -10);
                }
                if (player.position.equals(goldPositions[1])) {
                    ++achievedPoints;
                    goldPositions[1].setLocation(-10, -10);
                }
                if (achievedPoints == 3) rich = true;
            }

            if (level == 3) {

                BoardLevel.drawLevelThree(player.position, goldPositions2, doorPosition3,
                        snake.positions, springboardPosition3, magicPotionPosition3,
                        shieldPosition3, swordPosition3);

                if (player.position.equals(goldPositions2[0])) {
                    ++achievedPoints;
                    goldPositions2[0].setLocation(-10, -10);
                }
                if (player.position.equals(goldPositions2[1])) {
                    ++achievedPoints;
                    goldPositions2[1].setLocation(-10, -10);
                }
                if (player.position.equals(goldPositions2[2])) {
                    ++achievedPoints;
                    goldPositions2[2].setLocation(-10, -10);
                }
                if (achievedPoints == 6) rich = true;
            }

            // Zusätzliche Informationen

            System.out.println("Level: " + level);
            System.out.println("Current score: " + achievedPoints);
            System.out.println("Highscore: " + pref.getInt(item1, 0));
            System.out.println("Elements: & = player, S = snake, $ = gold, # = door, D = springboard, " +
                    "Y = magic potion, O = shield, V = sword");
            System.out.println("Movement:  w = go up, a = go left, s = go down, d = go right");
            System.out.println("magic potion: " + potionActive + ", shield: " + shieldActive +
                    ", sword: " + swordActive + ", springboard: " + springboardActive + ", rich: " + rich);
            if (stepCount <= 15) System.out.println(snakeAsleep);
            if (stepCount > 15) System.out.println(snakeAwake);

            snake.addSnakeMovement(player.position);
            player.addPlayerMovement();
            

            // Status feststellen -> collision detection

            if ((level == 1 && rich && player.position.equals(doorPosition)) ||
                    (level == 2 && rich && player.position.equals(doorPosition2))) {
                stepCount = 0;
                potionCount = 0;
                shieldCount = 0;
                potionActive = false;
                shieldActive = false;
                swordActive = false;
                springboardActive = false;
                rich = false;
                level++;
            }

            if (level == 3 && rich && player.position.equals(doorPosition3)) {
                System.out.println("Gewonnen!");
                return;
            }

            if (achievedPoints > pref.getInt(item1, 0)) {
                pref.putInt(item1, achievedPoints);
            }

            if (player.position.equals(shieldPosition)) {
                shieldActive = true;
                shieldPosition.setLocation(-5, -5);
            }

            if (player.position.equals(shieldPosition2)) {
                shieldActive = true;
                shieldPosition2.setLocation(-5, -5);
            }

            if (player.position.equals(shieldPosition3)) {
                shieldActive = true;
                shieldPosition3.setLocation(-5, -5);
            }

            if (player.position.equals(magicPotionPosition)) {
                potionActive = true;
                magicPotionPosition.setLocation(-2, -3);
            }

            if (player.position.equals(magicPotionPosition2)) {
                potionActive = true;
                magicPotionPosition2.setLocation(-2, -3);
            }

            if (player.position.equals(magicPotionPosition3)) {
                potionActive = true;
                magicPotionPosition3.setLocation(-2, -3);
            }

            if (player.position.equals(springboardPosition) || player.position.equals(springboardPosition2)
                    || player.position.equals(springboardPosition3)) {
                springboardActive = true;
            }

            if (player.position.equals(swordPosition)) {
                swordActive = true;
                swordPosition.setLocation(-6, -7);
            }

            if (player.position.equals(swordPosition2)) {
                swordActive = true;
                swordPosition2.setLocation(-6, -7);
            }

            if (player.position.equals(swordPosition3)) {
                swordActive = true;
                swordPosition3.setLocation(-6, -7);
            }

            if (Arrays.asList(snake.positions).contains(player.position)) {
                if (shieldActive && shieldCount > 8) {
                    shieldActive = false;
                }
                else if (swordActive) {
                    snake.head.setLocation(-10, -10);
                } else if (!shieldActive){
                    System.out.println("ZZZZZZZ. Die Schlange hat dich!");
                    return;
                }
            }

        }
    }
}


