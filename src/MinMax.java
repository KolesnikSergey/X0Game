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

    public MinMax() {

        calculateScore = new CalculateScore();

    }

    public Cell calculateMove(char [] [] gameField,char player){
        Cell[][] cellsField = generateCellsField(gameField);

        Cell cell = minMax(2,player,cellsField);
        System.out.println("CordA"+cell.getCordinateA()+" CordB"+cell.getCordinateB());
        System.out.println("depth count = " + depthCount);
        return cell;
    }


    public Cell minMax(int depth, char player, Cell [][] gameFieldCellsArray){

        Cell [] [] CellsArray=gameFieldCellsArray;
        List<Cell> freeCellsList = generateFreeCells(gameFieldCellsArray);
       if(freeCellsList.isEmpty()){
            System.out.println("A++++++++++++");}

        depthCount+=1;
        int score=0;
        int maxScore=0;
        Cell bestCell=new Cell();
        bestCell.setScore(0);
        bestCell.setCordinateA(-1);
        bestCell.setCordinateB(-1);



        if ( freeCellsList.isEmpty() || depth == 0){
            score = calculateScore.calculateScore(gameFieldCellsArray,player);
            bestCell.setScore(score);

    }else {
        for(Cell cell : freeCellsList){
            CellsArray[cell.getCordinateA()][cell.getCordinateB()].setContent(player);

            if (cell.getContent() == player){
                Cell currentCell = minMax(depth-1,'X',CellsArray);
                score = currentCell.getScore();
                System.out.println("score"+score);
                if (score>maxScore){
                    System.out.println("bestScore" + score);
                    bestCell.setScore(score);
                    bestCell.setCordinateA(cell.getCordinateA());
                    bestCell.setCordinateB(cell.getCordinateB());
                }
            }else {
                Cell currentCell = minMax(depth-1,'O',CellsArray);
                score = currentCell.getScore();
                if (score<maxScore){
                    bestCell.setScore(score);
                    bestCell.setCordinateA(currentCell.getCordinateA());
                    bestCell.setCordinateB(currentCell.getCordinateB());
                }
            }
        }

    }



        return bestCell;
    }


    private List<Cell> generateFreeCells(Cell [][] gameFieldCellsArray ){
        Cell cell = new Cell();
        List<Cell> freeCellsList = new ArrayList<Cell>();
        for (int i = 0; i <gameFieldCellsArray.length  ; i++) {
            for (int j = 0; j <gameFieldCellsArray.length ; j++) {

                cell = gameFieldCellsArray[i][j];
                System.out.print("A" + cell.getCordinateA());
                System.out.print(" B"+cell.getCordinateB());
                System.out.println(" cell inside-" + cell.getContent() + "-");

                char sign = cell.getContent();
                char empty = ' ';
               // System.out.println("sign-"+sign+"-");
               // System.out.println("empty-"+empty+"-");

                if ((cell.getContent()) == ' '){
                    System.out.println("cell A="+cell.getCordinateA()+" cellB="+cell.getCordinateB());
                    freeCellsList.add(cell);
                }

            }
        }

        //for (Cell cell1: freeCellsList){
        //    System.out.println("a"+cell1.getCordinateA());
       // }
        return freeCellsList;
    }

    private Cell[] [] generateCellsField(char[] [] gameField){


        Cell[] [] cellsField = new  Cell[gameField.length][gameField.length];


        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                char sign = gameField[i][j];
                Cell cell = new Cell();
                cell.setContent(sign);
                cell.setCordinateA(i);
                cell.setCordinateB(j);
                cellsField[i][j]=cell;
            }
        }

       return cellsField;
    }





    public int max(char[] [] gameField){

        return 0;
    }
}
