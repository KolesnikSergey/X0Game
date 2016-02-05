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

    public int calculateLineNew(int i,Cell cell,int score){
        int player=cell.getContent();

        if (i==0){
            if (player==2){score=1;}
        }

        if (i==1) {
            if (player == 2) {
                if (score==1){score=10;}
            }
        }

        if (i==2){
            if (player==2){
                if (score==10){score=100;}
            }
        }


        return score;
    }

    public int calculateLine(int i,Cell cell,int score){

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
                score=1;
                } else if (score==0){  // cell1 is empty
                    score = 1;
                }
            } else if (sighn == 1) {
                if (score == -1) { // cell1 is oppSeed
                    score = -10;
                } else if (score == 1) { // cell1 is mySeed
                    score=-1;
                } else {
                 if (score==0){// cell1 is empty
                     score = -1; }

                }
            }
        }
        // Third cell
        if (i==2) {
            if (sighn == 2) {
                if (score == 1) {  // cell1 and/or cell2 is mySeed
                    score *= 10;

                }else if (score == 10) {
                    score *= 13;

                }else if (score == -1) {  // cell1 or cell2 is oppSeed
                    score=1;
                } else if (score==-10){  // cell1 and cell2 are oppSeed
                    score*= 10;
                }
            } else if (sighn == 1) {
                if (score == -1) {  // cell1 and/or cell2 is oppSeed
                    score *= 10;
                } else if (score==-10){
                    score*=10;
                }else if (score == 1) {  // cell1 and/or cell2 is mySeed
                  score=1;
                } else {  // cell1 and cell2 are empty
                    if (sighn==0){score = 0;}
                }
            }else if (score == 15){
            score=20;
            }
        }

    return score;}

    public int calculateColumn(Cell[] [] cellsGameField,int column, int player){

        int score=0;




            for (int i = 0; i <cellsGameField.length ; i++) {

                Cell cell = cellsGameField[i][column];

                score=calculateLine(i,cell,score);

            }
            //System.out.println("column["+ (j+1) +"] ="+ column[j]);

        return score;
    }

    public int calculateRow(Cell[] [] cellsGameField,int row, int player){

        int score = 0;

        for (int j = 0; j <cellsGameField.length ; j++) {

            Cell cell = cellsGameField[row][j];

            score=calculateLine(j,cell,score);
        }
        //System.out.println("column["+ (j+1) +"] ="+ column[j]);

        return score;}

    public int calculateDiagonal(Cell[] [] cellsGameField, int player){
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

    public int calculateReverseDiagonal(Cell[] [] cellsGameField, int player){
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
