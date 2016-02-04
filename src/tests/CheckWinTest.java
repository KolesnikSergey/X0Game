package tests;

import game.checkWin.CheckWin;
import org.junit.*;

import static org.junit.Assert.*;

public class CheckWinTest {
    private static CheckWin checkWin;

    @BeforeClass
    public static void setUp() {
      checkWin = new CheckWin();
        System.out.println("@Before - setUp \n checkWin initialization");
    }


    @org.junit.Test
    public void testCheckGame() throws Exception {
        int[][] gameField = {
                {1, 1, 1},
                {0, 0, 0},
                {0, 0, 0}
        };
        final boolean result = checkWin.checkGame(gameField);
        assertEquals(true,result);
    }

    @org.junit.Test
    public void testCheckPlayer() throws Exception {
        int[][] gameField = {
            {0, 0, 1},
            {0, 1, 0},
            {1, 0, 0}
    };
        int player=1;
        final boolean relult = checkWin.checkPlayer(gameField, player);

        assertEquals(true,relult);



    }
}