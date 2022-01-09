package game;

import java.util.Scanner;

public class Player {
    public static void addPlayerMovement() {

        switch (new Scanner(System.in).next()) {

            case "w":
                SnakeGameDriver.stepCount++;
                SnakeGameDriver.shieldCount++;
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    SnakeGameDriver.playerPosition.y = Math.max(0, SnakeGameDriver.playerPosition.y - 2);
                    if (SnakeGameDriver.potionCount > 8) {
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.boardActive) {
                    SnakeGameDriver.playerPosition.y = Math.max(0, SnakeGameDriver.playerPosition.y - 5);
                    SnakeGameDriver.boardActive = false;
                } else {
                    SnakeGameDriver.playerPosition.y = Math.max(0, SnakeGameDriver.playerPosition.y - 1);
                }
                break;

            case "s":
                SnakeGameDriver.stepCount++;
                SnakeGameDriver.shieldCount++;
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    SnakeGameDriver.playerPosition.y = Math.max(0, SnakeGameDriver.playerPosition.y + 2);
                    if (SnakeGameDriver.potionCount > 8) {
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.boardActive) {
                    SnakeGameDriver.playerPosition.y = Math.max(0, SnakeGameDriver.playerPosition.y + 5);
                    SnakeGameDriver.boardActive = false;
                } else {
                    if (SnakeGameDriver.level == 1) {
                        SnakeGameDriver.playerPosition.y = Math.min(9, SnakeGameDriver.playerPosition.y + 1);
                    } else if (SnakeGameDriver.level == 2 || SnakeGameDriver.level == 3) {
                        SnakeGameDriver.playerPosition.y = Math.min(14, SnakeGameDriver.playerPosition.y + 1);
                    }
                }
                break;

            case "a":
                SnakeGameDriver.stepCount++;
                SnakeGameDriver.shieldCount++;
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    SnakeGameDriver.playerPosition.x = Math.max(0, SnakeGameDriver.playerPosition.x - 2);
                    if (SnakeGameDriver.potionCount > 8) {
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.boardActive) {
                    SnakeGameDriver.playerPosition.x = Math.max(0, SnakeGameDriver.playerPosition.x - 8);
                    SnakeGameDriver.boardActive = false;
                } else {
                    SnakeGameDriver.playerPosition.x = Math.max(0, SnakeGameDriver.playerPosition.x - 1);
                }
                break;

            case "d":
                SnakeGameDriver.stepCount++;
                SnakeGameDriver.shieldCount++;
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    SnakeGameDriver.playerPosition.x = Math.max(0, SnakeGameDriver.playerPosition.x + 2);
                    if (SnakeGameDriver.potionCount > 8) {
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.boardActive) {
                    SnakeGameDriver.playerPosition.x = Math.max(0, SnakeGameDriver.playerPosition.x + 8);
                    SnakeGameDriver.boardActive = false;
                } else {
                    if (SnakeGameDriver.level == 1) {
                        SnakeGameDriver.playerPosition.x = Math.min(59, SnakeGameDriver.playerPosition.x + 1);
                    } else if (SnakeGameDriver.level == 2) {
                        SnakeGameDriver.playerPosition.x = Math.min(69, SnakeGameDriver.playerPosition.x + 1);
                    } else if (SnakeGameDriver.level == 3) {
                        SnakeGameDriver.playerPosition.x = Math.min(79, SnakeGameDriver.playerPosition.x + 1);
                    }
                }
                break;
        }
    }
}
