import java.awt.*;

public class Snake {


    static Point snakeHead = new Point(
            SnakeGameDriver.snakePositions[SnakeGameDriver.snakeIdx].x,
            SnakeGameDriver.snakePositions[SnakeGameDriver.snakeIdx].y);



     // Methoden

    public static Point getSnakeHead(){
        return snakeHead;
    }


    public static void addSnakeMovement() {

        if (Player.getStepCount() > 15) {

            if (Player.getPlayerPosition().x < snakeHead.x) // Wenn die x Koordinate von PlayerPosition kleiner als
                snakeHead.x--;                              // von snakeHead ist, wird das x von snakeHead verringert

            else if (Player.getPlayerPosition().x > snakeHead.x)
                snakeHead.x++;


            if (Player.getPlayerPosition().y < snakeHead.y)
                snakeHead.y--;

            else if (Player.getPlayerPosition().y > snakeHead.y)
                snakeHead.y++;

            SnakeGameDriver.snakeIdx = (SnakeGameDriver.snakeIdx + 1) % SnakeGameDriver.snakePositions.length;
            SnakeGameDriver.snakePositions[SnakeGameDriver.snakeIdx] = snakeHead;
            // Es wird festgelegt welche der drei snakePositions der Kopf der Schlange ist.
        }
    }
}
