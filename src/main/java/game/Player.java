package game;

import java.awt.*;

public class Player {

    Point position = new Point();
    int stepCount = 0; // wird verwendet, damit der Spieler ein paar Züge hat, bevor sich die Schlange bewegt

    public Player (){
        position.setLocation((int) (Math.random() * 59), (int) (Math.random() * 9));  
    }

    public Player (int x, int y){  // wird zum Testen gebraucht
        position.setLocation(x,y);
    }

    public void addPlayerMovement( String input ) {

        stepCount++;

        if (SnakeGameDriver.shieldActive) {
            SnakeGameDriver.shieldCount++;
        }

        switch (input) {

            case "w":
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    position.y = Math.max(0, position.y - 2); //Math.max verhindert, dass der Spieleraußerhalb des Spielfelds laufen kann
                    if (SnakeGameDriver.potionCount > 8) {    //damit der Zaubertrank nur 7 Züge aktiv ist
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

    public int getPositionX (){  // wird zum Testen gebraucht
        return position.x;
    }
    public int getPositionY (){
        return position.y;
    }
}
