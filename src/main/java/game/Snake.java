package game;

import java.awt.*;

/** Die Klasse für die Schlange*/
public class Snake {
/** Die notwendigen Variablen für die Klasse Snake werden deklariert. */
    Point[] positions = new Point[3]; // positions.length gibt die Länge der Schlange an
    Point head;
    int snakeIdx = 0;

    /**Die Schlange bekommt eine Position, die mit dem snakeIdx festgelegt wird. */
    public Snake () {
        positions[snakeIdx] = new Point ((int) (Math.random() * 59), (int) (Math.random() * 9));
    }

    /** Wird zum Testen gebraucht
     * @param x X-Koordinate
     * @param y y-Koordinate */
    public Snake (int x, int y){
        positions[0] = new Point (x,y);
    }

    /** Die Methode sorgt für die Bewegung der Schlange im Spiel.
     * "snakeIdx = (snakeIdx + 1) % positions.length" und "positions[snakeIdx] = head" sorgen für die Rotation bzw. die Bestimmung, welcher Teil der Schlange der Kopf ist.
     *
     * Durch eine IF ELSE IF Überprüfung bewegt sich die Schlange in Richtung des Spielers.
     * Wenn die x-Koordinate des Spielers kleiner ist als die x-Koordinate des Schlangenkopfes wird die x-Koordinate des Schlangenkopfes verringert.
     * Wenn sie größer als die der Schlange ist, wird die Schlangen-Koordinate vergrößert. Das Gleiche wird bei den y-Koordinaten gemacht.
     * @param stepCount Anzahl der Schritte, die der Spieler bereits getätigt hat.
     * @param playerPosition aktuelle Position des Spielers.*/
    public void addSnakeMovement(int stepCount, Point playerPosition) {

        head = new Point(positions[snakeIdx].x, positions[snakeIdx].y);

        if (stepCount > 15) {

            if (playerPosition.x < head.x) {
                head.x--;
            }
            else if (playerPosition.x > head.x) {
                head.x++;
            }
            if (playerPosition.y < head.y) {
                head.y--;
            }
            else if (playerPosition.y > head.y++) { // das head.y++ sorgt für den Zicksacklauf
                head.y++;
            }

            snakeIdx = (snakeIdx + 1) % positions.length; //sorgt für eine Rotation der Arrays, dadurch bewegt sich die Schlange
            positions[snakeIdx] = head;
        }
    }
/** Diese Methode legt die Position der Schlange in Level 2 und 3 fest.
 * Durch eine IF Überprüfung wird das Level festgestellt.
 * Dann wird die erste Position im Array positions (wegen snakeIDX = 0) mit einem neuen Punkt im Koordinatensystem versehen.
 * @param level das aktuelle Level.*/
    public void setRandomPosition (int level){
        snakeIdx = 0;
        positions[1] = null;
        positions[2] = null;
        if (level == 2){
            positions[snakeIdx] = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));
        }
        if (level == 3){
            positions[snakeIdx] = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));
        }
    }
/** Methode wird zum Testen gebraucht
 * @param arrayNumber Nummer des Arrays
 * @return int  */
    public int getPositionX (int arrayNumber){
        return positions[arrayNumber].x;
    }

/** Methode wird zum Testen gebraucht
 * @param arrayNumber Nummer des Arrays
 * @return int */
    public int getPositionY (int arrayNumber){
        return positions[arrayNumber].y;
    }
}
