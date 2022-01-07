import java.awt.*;
import java.util.Arrays;

public class Level_2_Elements {
    // Klassenvariablen
    static Point doorPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));

    static Point[] goldPositions = {
            new Point((int) (Math.random() * 69), (int) (Math.random() * 14)),
            new Point((int) (Math.random() * 69), (int) (Math.random() * 14)) };

    static Point magicPotionPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));

    static Point shieldPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));

    static Point springboardPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));

    static Point swordPosition2 = new Point((int) (Math.random() * 69), (int) (Math.random() * 14));


    //Methoden

    public static Point[] Elements(){
        Point[] levelTwoElements = {goldPositions[0],goldPositions[1], doorPosition2, magicPotionPosition2,
                shieldPosition2, springboardPosition2, swordPosition2};

        return levelTwoElements;
    }

    public static Point[] getLevelTwoElements(){

        Point[] levelTwo = Elements();
        return levelTwo;
    }

    public static Point[] getGoldPositions(){
        return goldPositions;
    }
}
