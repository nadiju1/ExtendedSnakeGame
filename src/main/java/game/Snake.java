package game;

import java.awt.*;

public class Snake {

    Point[] positions = new Point[3];
    Point head;
    int snakeIdx = 0;

    public Snake () {
        positions[snakeIdx] = new Point ((int) (Math.random() * 59), (int) (Math.random() * 9));
    }

    public void addSnakeMovement(Point playerPosition) {

        head = new Point(positions[snakeIdx].x, positions[snakeIdx].y);

        if (SnakeGameDriver.stepCount > 15) {

            if (playerPosition.x < head.x) {
                head.x--;
            }
            else if (playerPosition.x > head.x) {
                head.x++;
            }
            if (playerPosition.y < head.y) {
                head.y--;
            }
            else if (playerPosition.y > head.y++) {
                head.y++;
            }

            snakeIdx = (snakeIdx + 1) % positions.length;
            positions[snakeIdx] = head;
        }
    }


}
