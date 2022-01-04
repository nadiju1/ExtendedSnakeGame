import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.prefs.Preferences;

public class SnakeGameDriver {

    @SuppressWarnings( "resource" )
    public static void main( String[] args ) {
        Point playerPosition = new Point(10, 9);
        Point goldPosition = new Point(6, 6);
        Point doorPosition = new Point(0, 5);
        Point[] snakePositions = new Point[5];
        int snakeIdx = 0;
        snakePositions[snakeIdx] = new Point(30, 2);
        boolean rich = false;
        int achievedPoints = 0;

        // Wird benötigt um Highscore zu speichern
        Preferences pref = Preferences.userNodeForPackage(SnakeGameDriver.class);
        final String item1 = "item1";

            while (true) {

                // Raster mit Figuren zeichnen

                for (int y = 0; y < 20; y++) {
                    for (int x = 0; x < 80; x++) {
                        Point p = new Point(x, y);
                        if (playerPosition.equals(p))
                            System.out.print('&');
                        else if (Arrays.asList(snakePositions).contains(p))
                            System.out.print('S');
                        else if (goldPosition.equals(p))
                            System.out.print('$');
                        else if (doorPosition.equals(p))
                            System.out.print('#');
                        else System.out.print('.');
                    }
                    System.out.println();
                }

                // Zusätzliche Informationen

                System.out.println("Current score: " + achievedPoints);
                System.out.println("Highscore: " + pref.getInt(item1, 0));

                // Status feststellen -> collision detection

                if (rich && playerPosition.equals(doorPosition)) {
                    if (achievedPoints > pref.getInt(item1, 0)) {
                        pref.putInt(item1, achievedPoints);
                    }
                    System.out.println("Gewonnen!");
                    return;
                }
                if (Arrays.asList(snakePositions).contains(playerPosition)) {
                    System.out.println("ZZZZZZZ. Die Schlange hat dich!");
                    return;
                }
                if (playerPosition.equals(goldPosition)) {
                    ++achievedPoints;
                    rich = true;
                    goldPosition.setLocation(-1, -1);
                }

                // Konsoleneingabe und Spielerposition verändern

                switch (new Scanner(System.in).next()) {
                    // Spielfeld ist im Bereich 0/0 .. 79/19
                    case "h":
                        playerPosition.y = Math.max(0, playerPosition.y - 1);
                        break;
                    case "t":
                        playerPosition.y = Math.min(19, playerPosition.y + 1);
                        break;
                    case "l":
                        playerPosition.x = Math.max(0, playerPosition.x - 1);
                        break;
                    case "r":
                        playerPosition.x = Math.min(79, playerPosition.x + 1);
                        break;
                }

                // Schlange bewegt sich Richtung Spieler

                Point snakeHead = new Point(snakePositions[snakeIdx].x, snakePositions[snakeIdx].y);

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

