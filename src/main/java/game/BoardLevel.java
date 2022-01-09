package game;

import java.awt.*;
import java.util.Arrays;

public class BoardLevel {
    // Raster mit Figuren zeichnen, angepasst je nach Level

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
