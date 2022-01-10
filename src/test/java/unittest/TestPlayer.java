package unittest;

import game.Player;
import org.junit.Test;
import org.junit.Assert;

public class TestPlayer {


    @Test
    public void testGoLeft() {
        Player testPlayer = new Player(30, 5);
        testPlayer.addPlayerMovement("a");
        Assert.assertEquals(29, testPlayer.getPositionX());
        Assert.assertEquals(5, testPlayer.getPositionY());
    }

    @Test
    public void testGoRight() {
        Player testPlayer = new Player(30, 5);
        testPlayer.addPlayerMovement("d");
        Assert.assertEquals(31, testPlayer.getPositionX());
        Assert.assertEquals(5, testPlayer.getPositionY());
    }

    @Test
    public void testGoUp() {
        Player testPlayer = new Player(30, 5);
        testPlayer.addPlayerMovement("w");
        Assert.assertEquals(30, testPlayer.getPositionX());
        Assert.assertEquals(4, testPlayer.getPositionY());
    }

    @Test
    public void testGoDown() {
        Player testPlayer = new Player(30, 5);
        testPlayer.addPlayerMovement("s");
        Assert.assertEquals(30, testPlayer.getPositionX());
        Assert.assertEquals(6, testPlayer.getPositionY());
    }

    @Test
    public void testDontStepOverBoard() {
        Player testPlayer_1 = new Player(0, 0);
        testPlayer_1.addPlayerMovement("a");
        testPlayer_1.addPlayerMovement("w");
        Assert.assertEquals(0, testPlayer_1.getPositionX());
        Assert.assertEquals(0, testPlayer_1.getPositionY());

        Player testPlayer_2 = new Player(59, 9);
        testPlayer_2.addPlayerMovement("d");
        testPlayer_2.addPlayerMovement("s");
        Assert.assertEquals(59, testPlayer_2.getPositionX());
        Assert.assertEquals(9, testPlayer_2.getPositionY());
    }


}
