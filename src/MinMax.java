import minmax.Score.CalculateScore;
import minmax.cell.Cell;

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

    public Cell calculateMove(int [] [] gameField,int player){
        maxScore=0;
        Cell[][] cellsField = generateCellsField(gameField);

        Cell cell = minMax(2,player,cellsField);
        System.out.println("CordA"+cell.getCordinateA()+" CordB"+cell.getCordinateB());
        System.out.println("depth count = " + depthCount);
        return cell;
    }


    public Cell minMax(int depth, int player, Cell [][] CellsField){

        Cell [] [] CellsArray= CellsField;
        List<Cell> freeCellsList = generateFreeCells(CellsField);

        if (depthCount==0) {
            System.out.println("freeCellsList");
            for (Cell cell1 : freeCellsList) {
                System.out.println(cell1.getContent()+"A"+(cell1.getCordinateA()+1)+"B"+(cell1.getCordinateB()+1));
            }
        }
        depthCount+=1;
        int score = 0;
        Cell bestCell=new Cell();
        bestCell.setScore(0);
        bestCell.setCordinateA(-1);
        bestCell.setCordinateB(-1);



        if ( freeCellsList.isEmpty() || depth == 0){
            score = calculateScore.calculateScore(CellsField,player);
            bestCell.setScore(score);

    }else {

            for (Cell cell : freeCellsList) {

                CellsArray[cell.getCordinateA()][cell.getCordinateB()].setContent(player);

                if (player == 1) {
                    int bestScore = -100000;
                    Cell currentCell = minMax(depth - 1, player, CellsArray);
                    score = currentCell.getScore();
                    System.out.println("score" + score);

                    if (score > bestScore) {
                        bestScore = score;
                        bestCell.setScore(bestScore);
                        bestCell.setCordinateA(cell.getCordinateA());
                        bestCell.setCordinateB(cell.getCordinateB());
                    }

                } else {

                    player = 1;
                    int bestScore = 100000;

                    Cell currentCell = minMax(depth - 1, player, CellsArray);
                    score = currentCell.getScore();

                    if (score < bestScore) {
                        bestScore = score;
                        bestCell.setScore(bestScore);
                        bestCell.setCordinateA(cell.getCordinateA());
                        bestCell.setCordinateB(cell.getCordinateB());

                    }
                }

            }

        }





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
                    //System.out.println("A="+cell.getCordinateA()+" cellB="+cell.getCordinateB()+"content"+cell.getContent());
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
      //  System.out.println("cellsFeild");
      //  DisplayGameField displayGameField = new DisplayGameField();
       // displayGameField.printField(cellsField);

       return cellsField;
    }





    public int max(char[] [] gameField){

        return 0;
    }
}
