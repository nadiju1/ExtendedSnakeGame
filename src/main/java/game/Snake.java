package game;

import java.awt.*;

public class Snake {

    Point[] positions = new Point[3]; // positions.length gibt Länge der Schlange an
    Point head;
    int snakeIdx = 0;

    public Snake () {
        positions[snakeIdx] = new Point ((int) (Math.random() * 59), (int) (Math.random() * 9));
    }

    public Snake (int x, int y){    //wird zum Testen gebraucht
        positions[0] = new Point (x,y);
    }

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

    public int getPositionX (int arrayNumber){ // wird zum Testen gebraucht
        return positions[arrayNumber].x;
    }

    public int getPositionY (int arrayNumber){
        return positions[arrayNumber].y;
    }
}
