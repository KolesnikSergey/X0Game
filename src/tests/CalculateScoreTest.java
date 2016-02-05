package tests;

import minmax.Score.CalculateScore;
import minmax.cell.Cell;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateScoreTest {


    @Test
    public void testCalculateScore() throws Exception{

        int [][] gameFieldField = {
                {0,1,2},
                {0,1,2},
                {0,0,2}
        };
        CalculateScore calculateScore = new CalculateScore();
        Cell[][] cellsField = generateCellsField(gameFieldField);
        int player =1;
        int column = 1;

        int score = calculateScore.calculateScore(cellsField,player);

        assertEquals(-100, score);





    }

    @Test
    public void testCalculateColumn() throws Exception{
        int [][] gameFieldField = {
                {0,0,0},
                {0,1,0},
                {0,1,0}
        };
        CalculateScore calculateScore = new CalculateScore();
        Cell[][] cellsField = generateCellsField(gameFieldField);
        int player =1;
        int column = 1;
        int score = calculateScore.calculateColumn(cellsField,column,player);

        assertEquals(-10, score);

    }
    @Test()
    public void testCalculateRow() throws Exception {

       int [][] gameFieldField = {
                {2,2,2},
                {0,0,0},
                {0,2,0}
        };
        CalculateScore calculateScore = new CalculateScore();
        Cell[][] cellsField = generateCellsField(gameFieldField);
        int player =1;
        int row = 0;
        int score = calculateScore.calculateRow(cellsField,row,player);

        assertEquals(130, score);
    }
    @Test
    public void testCalculateLine() throws Exception {
        CalculateScore calculateScore = new CalculateScore();

        int[][] gameFieldField = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 2}
        };

        Cell[][] cellsField = generateCellsField(gameFieldField);
        int score = 0;
        Cell cell = cellsField[0][0];

        score = calculateScore.calculateLine(0, cell, score);
        cell = cellsField[1][1];
        score = calculateScore.calculateLine(1, cell, score);
        cell = cellsField[2][2];
        score = calculateScore.calculateLine(2, cell, score);

        assertEquals(0, 0);
    }



    private Cell[] [] generateCellsField(int[] [] gameField){


        Cell[] [] cellsField = new  Cell[gameField.length][gameField.length];


        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                int sign = gameField[i][j];

                Cell cell = new Cell();
                cell.setContent(sign);
                cell.setCordinateA(i);
                cell.setCordinateB(j);
                cellsField[i][j]=cell;
            }
        }

        return cellsField;
    }
}