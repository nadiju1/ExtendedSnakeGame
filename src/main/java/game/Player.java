package game;

import java.awt.*;
import java.util.Scanner;

public class Player {

    Point position = new Point();
    
    public Player (){
        position.setLocation((int) (Math.random() * 59), (int) (Math.random() * 9));  
    }

    public void addPlayerMovement() {

        SnakeGameDriver.stepCount++;

        if (SnakeGameDriver.shieldActive) {
            SnakeGameDriver.shieldCount++;
        }

        switch (new Scanner(System.in).next()) {

            case "w":
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    position.y = Math.max(0, position.y - 2);
                    if (SnakeGameDriver.potionCount > 8) {
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.springboardActive) {
                    position.y = Math.max(0, position.y - 5);
                    SnakeGameDriver.springboardActive = false;
                } else {
                    position.y = Math.max(0, position.y - 1);
                }
                break;

            case "s":
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    position.y = Math.max(0, position.y + 2);
                    if (SnakeGameDriver.potionCount > 8) {
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.springboardActive) {
                    position.y = Math.max(0, position.y + 5);
                    SnakeGameDriver.springboardActive = false;
                } else {
                    if (SnakeGameDriver.level == 1) {
                        position.y = Math.min(9,position.y + 1);
                    } else if (SnakeGameDriver.level == 2 || SnakeGameDriver.level == 3) {
                        position.y = Math.min(14, position.y + 1);
                    }
                }
                break;

            case "a":
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    position.x = Math.max(0, position.x - 2);
                    if (SnakeGameDriver.potionCount > 8) {
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.springboardActive) {
                    position.x = Math.max(0, position.x - 8);
                    SnakeGameDriver.springboardActive = false;
                } else {
                    position.x = Math.max(0, position.x - 1);
                }
                break;

            case "d":
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    position.x = Math.max(0, position.x + 2);
                    if (SnakeGameDriver.potionCount > 8) {
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.springboardActive) {
                    position.x = Math.max(0, position.x + 8);
                    SnakeGameDriver.springboardActive = false;
                } else {
                    if (SnakeGameDriver.level == 1) {
                        position.x = Math.min(59, position.x + 1);
                    } else if (SnakeGameDriver.level == 2) {
                        position.x = Math.min(69, position.x + 1);
                    } else if (SnakeGameDriver.level == 3) {
                        position.x = Math.min(79, position.x + 1);
                    }
                }
                break;
        }
    }
}
