package game;

import java.util.Scanner;

public class Player {
    public static void addPlayerMovement() {

        SnakeGameDriver.stepCount++;

        if (SnakeGameDriver.shieldActive) {
            SnakeGameDriver.shieldCount++;
        }

        switch (new Scanner(System.in).next()) {

            case "w":
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    SnakeGameDriver.playerPosition.y = Math.max(0, SnakeGameDriver.playerPosition.y - 2);
                    if (SnakeGameDriver.potionCount > 8) {
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.springboardActive) {
                    SnakeGameDriver.playerPosition.y = Math.max(0, SnakeGameDriver.playerPosition.y - 5);
                    SnakeGameDriver.springboardActive = false;
                } else {
                    SnakeGameDriver.playerPosition.y = Math.max(0, SnakeGameDriver.playerPosition.y - 1);
                }
                break;

            case "s":
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    SnakeGameDriver.playerPosition.y = Math.max(0, SnakeGameDriver.playerPosition.y + 2);
                    if (SnakeGameDriver.potionCount > 8) {
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.springboardActive) {
                    SnakeGameDriver.playerPosition.y = Math.max(0, SnakeGameDriver.playerPosition.y + 5);
                    SnakeGameDriver.springboardActive = false;
                } else {
                    if (SnakeGameDriver.level == 1) {
                        SnakeGameDriver.playerPosition.y = Math.min(9, SnakeGameDriver.playerPosition.y + 1);
                    } else if (SnakeGameDriver.level == 2 || SnakeGameDriver.level == 3) {
                        SnakeGameDriver.playerPosition.y = Math.min(14, SnakeGameDriver.playerPosition.y + 1);
                    }
                }
                break;

            case "a":
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    SnakeGameDriver.playerPosition.x = Math.max(0, SnakeGameDriver.playerPosition.x - 2);
                    if (SnakeGameDriver.potionCount > 8) {
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.springboardActive) {
                    SnakeGameDriver.playerPosition.x = Math.max(0, SnakeGameDriver.playerPosition.x - 8);
                    SnakeGameDriver.springboardActive = false;
                } else {
                    SnakeGameDriver.playerPosition.x = Math.max(0, SnakeGameDriver.playerPosition.x - 1);
                }
                break;

            case "d":
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    SnakeGameDriver.playerPosition.x = Math.max(0, SnakeGameDriver.playerPosition.x + 2);
                    if (SnakeGameDriver.potionCount > 8) {
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.springboardActive) {
                    SnakeGameDriver.playerPosition.x = Math.max(0, SnakeGameDriver.playerPosition.x + 8);
                    SnakeGameDriver.springboardActive = false;
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
