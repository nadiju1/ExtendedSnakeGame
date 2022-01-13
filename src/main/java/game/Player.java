package game;

import java.awt.*;

/**Die Klasse für den Spieler */
public class Player {
 /** Variablen für den Spieler werden deklariert.
  * Der stepCount wird verwendet, damit der Spieler ein paar Züge hat, bevor sich die Schlange bewegt. */
    Point position = new Point();
    int stepCount = 0;

    /**Dem Spieler wird eine Position zugewiesen mit .setLocation()*/
    public Player (){
        position.setLocation((int) (Math.random() * 59), (int) (Math.random() * 9));  
    }

    /** Wird zum Testen gebraucht
     * @param x x-Koordinate
     * @param y y-Koordinate */
    public Player (int x, int y){
        position.setLocation(x,y);
    }

    /** Diese Methode sorgt für die Bewegung des Spielers. In ihr wird der stepCount erhöht.
     * Falls die boolean Variable shieldActive aus SnakeGameDriver true ist, wird der shieldCount erhöht.
     *
     * Der input des Spielers wird in einem Switch Case abgefragt.
     * @param input Eingabe des Spielers durch den Scanner. */
    public void addPlayerMovement( String input ) {

        stepCount++;

        if (SnakeGameDriver.shieldActive) {
            SnakeGameDriver.shieldCount++;
        }

        /* Durch das Switch Case wird die Bewegung des Spielers gesteuert. */
        switch (input) {

            case "w":
                if (SnakeGameDriver.potionActive) {
                    SnakeGameDriver.potionCount++;
                    position.y = Math.max(0, position.y - 2); //Math.max verhindert, dass der Spieler außerhalb des Spielfelds laufen kann
                    if (SnakeGameDriver.potionCount > 8) {    //damit der Zaubertrank nur 7 Züge aktiv ist
                        SnakeGameDriver.potionActive = false;
                    }
                } else if (SnakeGameDriver.springboardActive) {
                    position.y = Math.max(0, position.y - 5);
                    SnakeGameDriver.springboardActive = false;
                } else {
                    position.y = Math.max(0, position.y - 1);
                }
                break; // Break damit kein Fall-Through passiert.

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

    /** Methode zum Testen
     * @return int*/
    public int getPositionX (){
        return position.x;
    }

    /** Methode zum Testen
     * @return int*/
    public int getPositionY (){
        return position.y;
    }
}
