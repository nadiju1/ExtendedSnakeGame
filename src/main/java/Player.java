import java.awt.*;

public class Player {
    // Klassenvariablen
    private static Point playerPosition=  new Point((int) (Math.random() * 59), (int) (Math.random() * 9));
    private static int stepCount = 0;


    // Methoden

    public static Point getPlayerPosition(){
        return playerPosition;
    }

    public static int getStepCount (){
        return stepCount;
    }



    SnakeGameDriver snakeGameDriver;
}
