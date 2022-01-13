package game;

import java.awt.*;
import java.util.Arrays;

/**In dieser Klasse werden die Methoden definiert, die zum Erstellen des Spielfeldes benötigt werden. */

public class BoardLevel {
    // Raster mit Figuren zeichnen, angepasst je nach Level
/** Diese Methode wird gebraucht um das Spielfeld für das erste Level zu zeichnen.
 * Die Größe des Spielfeldes wird in der verschachtelten For-Schleife festgelegt.
 * In der inneren For Schleife wird durch eine IF-ELSE IF Verzweigung geprüft, ob die Positionen der Gegenstände, des Spielers oder der Schlange
 * mit dem Punkt p übereinstimmen. Wenn die beiden Positionen übereinstimmen wird das jeweilige Symbol für den Gegenstand ausgegeben.
 * Falls sie nicht übereinstimmen landet man im letzten ELSE Zweig, in dem die Punkte für das Spielfeld ausgegeben werden.
 * Sobald die innere For Schleife abgeschlossen wurde, wird die nächste Zeile ausgegeben.
 * @param playerPosition Die Position des Spielers.
 * @param goldPosition Die Position des Goldstückes.
 * @param doorPosition Die Position der Tür.
 * @param snakePositions Die Position der Schlange.
 * @param springboardPosition Die Position des Sprungbretts.
 * @param magicPotionPosition Die Position des Zaubertrankes.
 * @param shieldPosition Die Position des Schildes.
 * @param swordPosition Die Position des Schwertes.*/
    public static void drawLevelOne(Point playerPosition, Point goldPosition,
                                    Point doorPosition, Point[] snakePositions, Point springboardPosition,
                                    Point magicPotionPosition, Point shieldPosition, Point swordPosition ) {

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 60; x++) {
                Point p = new Point(x, y);
                if (playerPosition.equals(p))
                    System.out.print('&');
                else if (Arrays.asList(snakePositions).contains(p))
                    System.out.print('S');
                else if (goldPosition.equals(p))
                    System.out.print('$');
                else if (doorPosition.equals(p))
                    System.out.print('#');
                else if (magicPotionPosition.equals(p))
                    System.out.print('Y');
                else if (shieldPosition.equals(p))
                    System.out.print('O');
                else if (springboardPosition.equals(p))
                    System.out.print('D');
                else if (swordPosition.equals(p))
                    System.out.print('V');
                else System.out.print('.');
            }
            System.out.println();
        }
    }

    /** Diese Methode wird gebraucht um das Spielfeld des zweiten Levels ausgegeben zu können.
     * Das Spielfeld wird vergrößert.
     * @param playerPosition Die aktuelle Position des Spielers.
     * @param goldPositions Die neue Position der Goldstücke.
     * @param doorPosition2 Die neue Position der Tür.
     * @param snakePositions Die neue (aktuelle) Position der Schlange.
     * @param springboardPosition2 Die neue Position des Sprungbretts.
     * @param magicPotionPosition2 Die neue Position des Zaubertrankes.
     * @param shieldPosition2 Die neue Position des Schilds.
     * @param swordPosition2 Die neue Position des Schwerts.*/
    public static void drawLevelTwo(Point playerPosition, Point[] goldPositions,
                                    Point doorPosition2, Point[] snakePositions,
                                    Point springboardPosition2, Point magicPotionPosition2,
                                    Point shieldPosition2, Point swordPosition2) {

        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 70; x++) {
                Point p = new Point(x, y);
                if (playerPosition.equals(p))
                    System.out.print('&');
                else if (Arrays.asList(snakePositions).contains(p))
                    System.out.print('S');
                else if (goldPositions[0].equals(p) ||goldPositions[1].equals(p) )
                    System.out.print('$');
                else if (doorPosition2.equals(p))
                    System.out.print('#');
                else if (magicPotionPosition2.equals(p))
                    System.out.print('Y');
                else if (shieldPosition2.equals(p))
                    System.out.print('O');
                else if (springboardPosition2.equals(p))
                    System.out.print('D');
                else if (swordPosition2.equals(p))
                    System.out.print('V');
                else System.out.print('.');
            }
            System.out.println();
        }
    }
    /** Diese Methode wird gebraucht um das Spielfeld des dritten Levels ausgegeben zu können.
     * Das Spielfeld des dritten wird wieder vergrößert.
     * @param playerPosition Die aktuelle Position des Spielers.
     * @param goldPositions2 Die neue Position der Goldstücke.
     * @param doorPosition3 Die neue Position der Tür.
     * @param snakePositions Die neue (aktuelle) Position der Schlange.
     * @param springboardPosition3 Die neue Position des Sprungbretts.
     * @param magicPotionPosition3 Die neue Position des Zaubertrankes.
     * @param shieldPosition3 Die neue Position des Schilds.
     * @param swordPosition3 Die neue Position des Schwerts.*/
    public static void drawLevelThree(Point playerPosition, Point[] goldPositions2,
                                      Point doorPosition3, Point[] snakePositions,
                                      Point springboardPosition3, Point magicPotionPosition3,
                                      Point shieldPosition3, Point swordPosition3) {


        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 80; x++) {
                Point p = new Point(x, y);
                if (playerPosition.equals(p))
                    System.out.print('&');
                else if (Arrays.asList(snakePositions).contains(p))
                    System.out.print('S');
                else if (goldPositions2[0].equals(p) || goldPositions2[1].equals(p) || goldPositions2[2].equals(p))
                    System.out.print('$');
                else if (doorPosition3.equals(p))
                    System.out.print('#');
                else if (magicPotionPosition3.equals(p))
                    System.out.print('Y');
                else if (shieldPosition3.equals(p))
                    System.out.print('O');
                else if (springboardPosition3.equals(p))
                    System.out.print('D');
                else if (swordPosition3.equals(p))
                    System.out.print('V');
                else System.out.print('.');
            }
            System.out.println();
        }
    }
}
