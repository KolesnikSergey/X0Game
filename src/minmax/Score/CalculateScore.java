package minmax.Score;

import minmax.cell.Cell;

/**
 * Created by Vadim on 31.01.2016.
 */
public class CalculateScore {


    public int calculateScore(Cell[][] gameField, int player){

        int score=0;

        score += calculateColumn(gameField,0,player);
        score += calculateColumn(gameField,1,player);
        score += calculateColumn(gameField,2,player);

        score+=calculateRow(gameField,0,player);
        score+=calculateRow(gameField,1,player);
        score+=calculateRow(gameField,2,player);

        score+=calculateDiagonal(gameField,player);
        score+=calculateReverseDiagonal(gameField,player);

        
        return score;
    }

    private int calculateLine(int i,Cell cell,int score){

        int sighn = cell.getContent();

        //first cell
        if ( i == 0 ) {
            if (sighn == 2) {
                score = 1;
            } else if (sighn == 1) {
                score = -1;
            }
        }

        // Second cell
        if (i==1) {
            if (sighn == 2) {
                if (score == 1) {   // cell1 is mySeed
                    score = 10;
                } else if (score == -1) {  // cell1 is oppSeed
                    return 0;
                } else {  // cell1 is empty
                    score = 1;
                }
            } else if (sighn == 1) {
                if (score == -1) { // cell1 is oppSeed
                    score = -10;
                } else if (score == 1) { // cell1 is mySeed
                    return 0;
                } else {  // cell1 is empty
                    score = -1;
                }
            }
        }
        // Third cell
        if (i==2) {
            if (sighn == 2) {
                if (score > 0) {  // cell1 and/or cell2 is mySeed
                    score *= 10;
                } else if (score < 0) {  // cell1 and/or cell2 is oppSeed
                    return 0;
                } else {  // cell1 and cell2 are empty
                    score = 1;
                }
            } else if (sighn == 1) {
                if (score < 0) {  // cell1 and/or cell2 is oppSeed
                    score *= 10;
                } else if (score > 1) {  // cell1 and/or cell2 is mySeed
                    return 0;
                } else {  // cell1 and cell2 are empty
                    score = -1;
                }
            }
        }

    return score;}

    private int calculateColumn(Cell[] [] cellsGameField,int column, int player){

        int score=0;




            for (int i = 0; i <cellsGameField.length ; i++) {

                Cell cell = cellsGameField[i][column];

                score=calculateLine(i,cell,score);

            }
            //System.out.println("column["+ (j+1) +"] ="+ column[j]);

        return score;
    }

    private int calculateRow(Cell[] [] cellsGameField,int row, int player){

        int score = 0;

        for (int j = 0; j <cellsGameField.length ; j++) {

            Cell cell = cellsGameField[row][j];

            score=calculateLine(j,cell,score);
        }
        //System.out.println("column["+ (j+1) +"] ="+ column[j]);

        return score;}

    private int calculateDiagonal(Cell[] [] cellsGameField, int player){
        int score=0;
        int count=0;
        for (int i = 0; i <cellsGameField.length ; i++) {

            for (int j = 0; j <cellsGameField.length ; j++) {

                if (i==j){

                    Cell cell = cellsGameField[i][j];

                    score= calculateLine(count,cell,score);
                    count+=1;

                }



            }

        }
        return score;
    }

    private int calculateReverseDiagonal(Cell[] [] cellsGameField, int player){
        int score=0;
        int count=0;
        for (int i = 0; i <cellsGameField.length ; i++) {

            for (int j = 0; j <cellsGameField.length ; j++) {

                if (( j + j ) == (cellsGameField.length-1)){

                    Cell cell = cellsGameField[i][j];

                    score= calculateLine(count,cell,score);
                    count+=1;

                }

            }

        }
        return score;
    }
    }
