import java.awt.*;

public class Level_3_Elements {

    // Klassenvariablen
    static Point doorPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));

    static Point[] goldPositions2 = {
            new Point((int) (Math.random() * 79), (int) (Math.random() * 14)), // [0]
            new Point((int) (Math.random() * 79), (int) (Math.random() * 14)), // [1]
            new Point((int) (Math.random() * 79), (int) (Math.random() * 14))}; // [2]

    static Point magicPotionPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));

    static Point shieldPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));

    static Point springboardPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));

    static Point swordPosition3 = new Point((int) (Math.random() * 79), (int) (Math.random() * 14));


    // Methoden

    public static Point[] Elements(){
        Point[] levelThreeElements = {goldPositions2[0],goldPositions2[1],goldPositions2[2], doorPosition3,
                magicPotionPosition3, shieldPosition3, springboardPosition3, swordPosition3};

        return levelThreeElements;
    }


    public static Point[] getLevelThreeElements(){

        Point[] levelThree = Elements();
        return levelThree;
    }

    public static Point[] getGoldPositions(){
        return goldPositions2;
    }

}
