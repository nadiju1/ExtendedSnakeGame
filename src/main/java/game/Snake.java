package game;

public class Snake {
    public static void addSnakeMovement() {

        if (SnakeGameDriver.stepCount > 15) {

            if (SnakeGameDriver.playerPosition.x < SnakeGameDriver.snakeHead.x) {
                SnakeGameDriver.snakeHead.x--;
            }
            else if (SnakeGameDriver.playerPosition.x > SnakeGameDriver.snakeHead.x) {
                SnakeGameDriver.snakeHead.x++;
            }
            if (SnakeGameDriver.playerPosition.y < SnakeGameDriver.snakeHead.y) {
                SnakeGameDriver.snakeHead.y--;
            }
            else if (SnakeGameDriver.playerPosition.y > SnakeGameDriver.snakeHead.y++) {
                SnakeGameDriver.snakeHead.y++;
            }

            SnakeGameDriver.snakeIdx = (SnakeGameDriver.snakeIdx + 1) % SnakeGameDriver.snakePositions.length;
            SnakeGameDriver.snakePositions[SnakeGameDriver.snakeIdx] = SnakeGameDriver.snakeHead;
        }
    }
}
