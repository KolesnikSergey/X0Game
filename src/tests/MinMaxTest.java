package tests;

import minmax.cell.Cell;
import minmax.minmax.MinMax;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinMaxTest {

    @Test
    public void testCalculateMove() throws Exception {

    }

    @Test
    public void testMinMax() throws Exception {

        int [][] gameField = {
                {2,0,0},
                {0,1,0},
                {0,0,1}
        };

        MinMax minMax =new MinMax();
        int player=2;
        int depth=4;

        int testMode=depth;

        Cell[][] cellsField = minMax.generateCellsField(gameField);

        Cell cell = minMax.minMax(depth, player, cellsField,testMode);
        System.out.println("score="+cell.getScore());
        System.out.println("A="+cell.getCordinateA()+"B="+cell.getCordinateB());

        assertEquals(1,2);
    }

    @Test
    public void testCellsListPrint() throws Exception {

    }

    @Test
    public void testCellsScorePrint() throws Exception {

    }
}