import java.awt.*;
import java.util.Arrays;

public class Level_1_Elements {

    static Point goldPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));

    static Point doorPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));

    static Point magicPotionPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));

    static Point shieldPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));

    static Point springboardPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));

    static Point swordPosition = new Point((int) (Math.random() * 59), (int) (Math.random() * 9));


    //Methoden

    public static Point[] Elements(){
        Point[] levelElements = {goldPosition, doorPosition, magicPotionPosition,
                shieldPosition, springboardPosition, swordPosition};

        return levelElements;
    }


    public static Point[] getLevelOneElements(){

        Point[] levelOne = Elements();
        return levelOne;
    }

}
