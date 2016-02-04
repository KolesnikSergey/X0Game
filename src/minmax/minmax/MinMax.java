package minmax.minmax;

import exeptions.NoFreeCellsException;
import minmax.Score.CalculateScore;
import minmax.cell.Cell;

import game.displaygame.DisplayGameField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadim on 30.01.2016.
 */
public class MinMax {
    private CalculateScore calculateScore;
    private int depthCount=0;
    int maxScore;

    public MinMax() {

        calculateScore = new CalculateScore();

    }

    public Cell calculateMove(int [] [] gameField,int player) throws NoFreeCellsException{
        maxScore=0;
        depthCount=0;

        Cell[][] cellsField = generateCellsField(gameField);

        Cell cell = minMax(1,player,cellsField);
        if ((cell.getCordinateA()<0) || (     ( cell.getCordinateB())<0 )    ){throw new NoFreeCellsException(); }

        //System.out.println("move calc A"+(cell.getCordinateA()+1)+" CordB"+(cell.getCordinateB()+1));
        //System.out.println("depth count = " + depthCount);
        return cell;
    }


    public Cell minMax(int depth, int player, Cell [][] CellsField){

        Cell [] [] cellsArray= CellsField;
        List<Cell> freeCellsList = generateFreeCells(CellsField);
/*
            System.out.println("freeCellsList depth="+depth);
            cellsListPrint(freeCellsList,CellsField);
*/

        depthCount+=1;
        int score = 0;
        Cell bestCell=new Cell();
        bestCell.setScore(0);
        bestCell.setCordinateA(-1);
        bestCell.setCordinateB(-1);


        int countFree=0;
        if ( freeCellsList.isEmpty() || depth == 0){
            score = calculateScore.calculateScore(CellsField,player);
            bestCell.setScore(score);
           // System.out.println("depth=0 score="+score);

    }else {

            for (Cell cell : freeCellsList) {

                cellsArray[cell.getCordinateA()][cell.getCordinateB()].setContent(player);

                if (player == 2) {
                    int bestScore = -100000;
                    player=1;
                    Cell currentCell = minMax(depth - 1, player, cellsArray);
                    player=2;
                    score = currentCell.getScore();
                   // System.out.println("Max");
                    //System.out.println("2 player Cell Score");
                    //System.out.println("cell A"+(cell.getCordinateA()+1)+" B"+(cell.getCordinateB()+1)+" score="+(cell.getScore()));

                    cell.setScore(score);
                   /* if (score > bestScore) {
                        //System.out.println("score>>>bestScore");
                        bestScore = score;
                        bestCell.setScore(bestScore);
                        bestCell.setCordinateA(cell.getCordinateA());
                        bestCell.setCordinateB(cell.getCordinateB());
                    }*/

                } else {

                    player = 2;
                    int bestScore = 100000;

                    Cell currentCell = minMax(depth - 1, player, cellsArray);
                    player=1;
                    score = currentCell.getScore();
                    cell.setScore(score);
                   // System.out.println("Min");
                    //System.out.println("1 player Cell Score");
                    //System.out.println("cell A"+(currentCell.getCordinateA()+1)+" B"+(currentCell.getCordinateB()+1)+" score="+(currentCell.getScore()));
                   /* if (score < bestScore) {
                        //System.out.println("score<<<bestScore");
                        bestScore = score;
                        bestCell.setScore(bestScore);
                        bestCell.setCordinateA(cell.getCordinateA());
                        bestCell.setCordinateB(cell.getCordinateB());

                    }*/
                }
                cellsArray[cell.getCordinateA()][cell.getCordinateB()].setContent(0);

            }
            int bestScore;
            if (player == 2) {
                bestScore = -100000;}
            else {bestScore= 100000;}

            for (Cell cell:freeCellsList){
                countFree+=1;
                /*
                System.out.println("A="+(cell.getCordinateA())+" B="+(cell.getCordinateB())+"score="+cell.getScore());
                */
                if(player==2){
                    if (cell.getScore()>bestScore){
                        bestScore = cell.getScore();
                        bestCell.setScore(bestScore);
                        bestCell.setCordinateA(cell.getCordinateA());
                        bestCell.setCordinateB(cell.getCordinateB());
                     //   System.out.println("max bestCell A="+(bestCell.getCordinateA())+" B="+(bestCell.getCordinateB())+"score="+bestCell.getScore());

                    }
                }
                else {
                    if (cell.getScore()<bestScore){
                        bestScore = cell.getScore();
                        bestCell.setScore(bestScore);
                        bestCell.setCordinateA(cell.getCordinateA());
                        bestCell.setCordinateB(cell.getCordinateB());
                       // System.out.println("min bestCell A="+(bestCell.getCordinateA())+" B="+(bestCell.getCordinateB())+"score="+bestCell.getScore());

                    }
                }

            }


           /* System.out.println("iterCount" + depthCount);
            System.out.println("freeCellsCount" + countFree);

            cellsScorePrint(freeCellsList, cellsArray);
            */
        }
      /*  System.out.println("iterCount" + depthCount);
        System.out.println("freeCellsCount" + countFree);

        cellsScorePrint(freeCellsList, cellsArray);

        System.out.println("return");
        System.out.println("cell A"+(bestCell.getCordinateA()+1)+" B"+(bestCell.getCordinateB()+1)+" score="+(bestCell.getScore()));
        System.out.println("scoreBestCell=" + bestCell.getScore() );
        */

        return bestCell;
    }


    private List<Cell> generateFreeCells(Cell [][] CellsField ){

        List<Cell> freeCellsList = new ArrayList<Cell>();
        for (int i = 0; i <CellsField.length  ; i++) {
            for (int j = 0; j <CellsField.length ; j++) {
                Cell cell = new Cell();
                cell.setContent(CellsField[i][j].getContent());
                cell.setCordinateA(CellsField[i][j].getCordinateA());
                cell.setCordinateB(CellsField[i][j].getCordinateB());

                if (cell.getContent()==0){

                    freeCellsList.add(cell);

                }

            }
        }

        return freeCellsList;
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


    public void cellsListPrint(List<Cell> cellList,Cell[] [] cellsField) {


        for (Cell cell : cellList) {
            cellsField[cell.getCordinateA()][cell.getCordinateB()].setContent(7);
        }
        DisplayGameField displayGameField = new DisplayGameField();
        displayGameField.printField(cellsField);

    }

    public void cellsScorePrint(List<Cell> cellList,Cell[] [] cellsField) {


        for (Cell cell : cellList) {
            cellsField[cell.getCordinateA()][cell.getCordinateB()].setScore(cell.getScore());
            System.out.println("ScorePrint");
            System.out.println("A="+(cell.getCordinateA())+" B="+(cell.getCordinateB())+"score="+cell.getScore());
        }
        DisplayGameField displayGameField = new DisplayGameField();
        System.out.println("Cells Score Field");
        displayGameField.printScoreField(cellsField);


    }


    public int max(char[] [] gameField){

        return 0;
    }
}
