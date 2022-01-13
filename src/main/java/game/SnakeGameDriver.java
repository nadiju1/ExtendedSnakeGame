package game;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.prefs.Preferences;

/**Die Driver Klasse */
public class SnakeGameDriver {
/** Notwendige Variablen werden deklariert und auf die Anfangseinstellung gesetzt. */
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
    /*Die Main Methode die zur Ausführung der Klasse benötigt wird.*/
    public static void main( String[] args ) {

        /* Variablen für die Elemente im ersten Level werden deklariert. */
        Point goldPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point doorPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point magicPotionPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point shieldPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point springboardPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Point swordPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
        Player player = new Player();
        Snake snake = new Snake ();

        /* Variablen für die Elemente im zweiten Level werden deklariert. Es kommt ein weiteres Goldstück zum Einsammeln hinzu.
         * Die Gegenstände werden für das zweite Level neu deklariert, damit sie eine neue Position im neuen Level bekommen.
         * Der Spieler und die Schlange bleiben gleich und werden nicht für jedes Level neu deklariert. */
        Point doorPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point[] goldPositions = new Point[2];
        goldPositions[0] = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        goldPositions[1] = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point magicPotionPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point shieldPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point springboardPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        Point swordPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));

       /* Variablen für die Elemente im dritten Level werden deklariert. Es kommt wieder ein neues Goldstück hinzu. */
        Point doorPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point[] goldPositions2 = new Point[3];
        goldPositions2[0] = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        goldPositions2[1] = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        goldPositions2[2] = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point magicPotionPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point shieldPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point springboardPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        Point swordPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));

        /* Die boolean Variable rich wird erst true wenn man alle Goldstücke hat. */
        boolean rich = false; // man braucht alle Golstücke für true

        /*Wird benötigt, um den Highscore zu speichern. */
        Preferences pref = Preferences.userNodeForPackage(SnakeGameDriver.class);
        final String item1 = "item1";

        /*Eine Spielanleitung wird für den Benutzer ausgegeben. */
        System.out.println("\nSammle alle Goldstücke ohne von der Schlange erwischt zu werden.\n" +
                           "Erreiche danach die Tür, um erfolgreich in den nächsten Raum zu flüchten.\n" +
                           "Ein paar Gegenstände könnten nützlich sein. Probiere sie aus.\n");

        while (true) {
        /* Falls level gleich 1 ist, wird das erste Level in der Konsole gezeichnet.
        * Falls die Position des Spielers mit der Position des Goldes übereinstimmt, wird die boolean Variable rich auf true gesetzt,
        * die Variable achievedPoints wird erhöht und die Position des Goldes vom Spielfeld entfernt.*/
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

            /* Falls die Variable level gleich 2 ist, wird das zweite Level in der Konsole gezeichnet.
             * In einer weiteren IF Überprüfung wird geschaut, ob die Spielerposition mit den Goldpositionen übereinstimmt.
             * Die Variable achievedPoints muss den Wert 3 haben, damit die boolean Variable rich true wird. */
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

            /*Wenn die Variable level den Wert 3 hat, wird das Spielfeld des dritten Levels ausgegeben.
            * In diesem Level muss die Variable achievedPoints den Wert 6 haben, damit die boolean Variable rich zu true wird.*/
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

            /* Zusätzliche Informationen werden für den Benutzer ausgegeben. Es wird das Level, die aktuelle Punktezahl und der Highscore,
             * sowie eine Erklärung der Zeichen im Spielfeld ausgegeben. Es wird auch gezeigt, ob aktuell ein Gegenstand (z.B. Shield) aktiv ist.*/
            System.out.println("Level: " + level);
            System.out.println("Current score: " + achievedPoints);
            System.out.println("Highscore: " + pref.getInt(item1, 0));
            System.out.println("Elements: & = player, S = snake, $ = gold, # = door, D = springboard, " +
                    "Y = magic potion, O = shield, V = sword");
            System.out.println("Movement:  w = go up, a = go left, s = go down, d = go right");
            System.out.println("magic potion: " + potionActive + ", shield: " + shieldActive +
                    ", sword: " + swordActive + ", springboard: " + springboardActive + ", rich: " + rich);
            if (player.stepCount <= 15) System.out.println(snakeAsleep);
            if (player.stepCount > 15) System.out.println(snakeAwake);

            /* Die Bewegung der Schlange wird eingefügt*/
            snake.addSnakeMovement(player.stepCount, player.position);

            /* Die Eingabe des Spielers wird ermöglicht durch den Scanner. */
            String input = new Scanner(System.in).next();
            player.addPlayerMovement(input);


            // Status feststellen -> collision detection
            if ((level == 1 && rich && player.position.equals(doorPosition)) ||
                    (level == 2 && rich && player.position.equals(doorPosition2))) {
                player.stepCount = 0;
                potionCount = 0;
                shieldCount = 0;
                potionActive = false;
                shieldActive = false;
                swordActive = false;
                springboardActive = false;
                rich = false;
                level++;
                snake.setRandomPosition(level);
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
            if (shieldActive && shieldCount > 8) {
               shieldActive = false; // verhindert, dass das Schild dauerhaft aktiv ist
            }

        /* Wenn das Array snake.positions die aktuelle Position des Spielers enthält, wird eine weitere IF Überprüfung ausgeführt.
         * Wenn nun das swordActive true ist, wird die Schlange getötet, wodurch die Position des Schlangenkopfes vom Spielfeld entfernt wird.
         * Wenn shieldActive NICHT true ist, wird ausgegeben, dass man von der Schlange gefangen wurde. */
            if (Arrays.asList(snake.positions).contains(player.position)) {
                if (swordActive) {
                    snake.head.setLocation(-10, -10);
                } else if (!shieldActive){
                    System.out.println("ZZZZZZZ. Die Schlange hat dich!");
                    return;
                }
            }

        } // While Schleife wird hier erst geschlossen.
    }
}


