package unittest;

import game.Snake;
import java.awt.*;
import org.junit.Assert;
import org.junit.Test;

public class TestSnake {

    @Test
    public void testStepCountBreak() {
        Snake testSnake = new Snake(45, 5);
        Point testPlayerPosition = new Point(1, 1);
        for (int i = 0; i < 15; i++) {
            testSnake.addSnakeMovement(i, testPlayerPosition); // stepCount = i
        }
        Assert.assertEquals(45, testSnake.getPositionX(0));
        Assert.assertEquals(5, testSnake.getPositionY(0));
    }

    @Test
    public void testPlayerAbove(){
        Snake testSnake = new Snake(45, 5);
        Point testPlayerPosition = new Point(45, 10);
        testSnake.addSnakeMovement(20, testPlayerPosition);
        Assert.assertEquals(45, testSnake.getPositionX(1)); // arrayNumber 1, weil die Arrays immer in einer Rotation verändert werden
        Assert.assertEquals(7, testSnake.getPositionY(1)); //immer yKoordinate + 1 wegen den Zickzacklauf außer ySpielerkoordinate < als Schlangenkoordinate

    }
    @Test
    public void testPlayerBelow(){
        Snake testSnake = new Snake(45, 5);
        Point testPlayerPosition = new Point(45, 0);
        testSnake.addSnakeMovement(20, testPlayerPosition);
        Assert.assertEquals(45, testSnake.getPositionX(1));
        Assert.assertEquals(4, testSnake.getPositionY(1));
    }

    @Test
    public void testPlayerLeft(){
        Snake testSnake = new Snake(45, 5);
        Point testPlayerPosition = new Point(40, 5);
        testSnake.addSnakeMovement(20, testPlayerPosition);
        Assert.assertEquals(44, testSnake.getPositionX(1));
        Assert.assertEquals(6, testSnake.getPositionY(1));
    }

    @Test
    public void testPlayerRight(){
        Snake testSnake = new Snake(45, 5);
        Point testPlayerPosition = new Point(50, 5);
        testSnake.addSnakeMovement(20, testPlayerPosition);
        Assert.assertEquals(46, testSnake.getPositionX(1));
        Assert.assertEquals(6, testSnake.getPositionY(1));
    }

    @Test
    public void testPlayerDiagonal(){
        Snake testSnake = new Snake(45, 5);
        Point testPlayerPosition = new Point(40, 10);
        testSnake.addSnakeMovement(20, testPlayerPosition);
        Assert.assertEquals(44, testSnake.getPositionX(1));
        Assert.assertEquals(7, testSnake.getPositionY(1));
    }
}