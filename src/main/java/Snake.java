import java.awt.*;

public class Snake {


    /* static Point snakeHead = new Point(
            SnakeGameDriver.snakePositions[SnakeGameDriver.snakeIdx].x,
            SnakeGameDriver.snakePositions[SnakeGameDriver.snakeIdx].y);



     // Methoden

    public static Point getSnakeHead(){
        return snakeHead;
    } */


    public static void addSnakeMovement() {

        if (Player.getStepCount() > 15) {

            if (Player.getPlayerPosition().x < SnakeGameDriver.snakeHead.x) // Wenn die x Koordinate von PlayerPosition kleiner als
                SnakeGameDriver.snakeHead.x--;                              // von snakeHead ist, wird das x von snakeHead verringert

            else if (Player.getPlayerPosition().x > SnakeGameDriver.snakeHead.x)
                SnakeGameDriver.snakeHead.x++;


            if (Player.getPlayerPosition().y < SnakeGameDriver.snakeHead.y)
                SnakeGameDriver.snakeHead.y--;

            else if (Player.getPlayerPosition().y > SnakeGameDriver.snakeHead.y)
                SnakeGameDriver.snakeHead.y++;

            SnakeGameDriver.snakeIdx = (SnakeGameDriver.snakeIdx + 1) % SnakeGameDriver.snakePositions.length;
            SnakeGameDriver.snakePositions[SnakeGameDriver.snakeIdx] = SnakeGameDriver.snakeHead;
            // Es wird festgelegt welche der drei snakePositions der Kopf der Schlange ist.
        }
    }
}
