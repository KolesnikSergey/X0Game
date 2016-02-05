package minmax.Score;

import minmax.cell.Cell;

/**
 * Created by Vadim on 31.01.2016.
 */
public class CalculateScore {


    public int calculateScore(Cell[][] gameField, int player){

        int score=0;

        score += calculateColumn(gameField,0);
        score += calculateColumn(gameField,1);
        score += calculateColumn(gameField,2);

        score+= calculateRow(gameField,0);
        score+= calculateRow(gameField,1);
        score+= calculateRow(gameField,2);

        score+= calculateDiagonal(gameField);
        score+= calculateReverseDiagonal(gameField);

        
        return score;
    }

    public int calculateLineVersion2(int i[],int score){

        // score 100
        if (i[0]==2 && i[1]==2 && i[2]==2){score=500;}//2 2 2
        //score 95

        if (i[0]==1 && i[1]==1 && i[2]==2){score=95;}// 1 1 2
        if (i[0]==2 && i[1]==1 && i[2]==1){score=95;}// 2 1 1
        if (i[0]==1 && i[1]==2 && i[2]==1){score=95;}// 1 2 1

        //score 10
        if (i[0]==2 && i[1]==2 && i[2]==0){score=10;}// 2 2 0
        if (i[0]==0 && i[1]==2 && i[2]==2){score=10;}//0 2 2
        if (i[0]==2 && i[1]==0 && i[2]==2){score=10;}//2 0 2
        //score 1
        if (i[0]==0 && i[1]==2 && i[2]==0){score=1;}// 0 2 0
        if (i[0]==0 && i[1]==0 && i[2]==2){score=1;}// 0 0 2
        if (i[0]==2 && i[1]==0 && i[2]==0){score=1;}// 2 0 0



        //score -100
        if (i[0]==1 && i[1]==1 && i[2]==1){score=-500;}// 1 1 1

        //score - 95

        if (i[0]==2 && i[1]==2 && i[2]==1){score=-95;}// 2 2 1
        if (i[0]==1 && i[1]==2 && i[2]==2){score=-95;}// 1 2 2
        if (i[0]==2 && i[1]==1 && i[2]==2){score=-95;}// 2 1 2


        //score -10
        if (i[0]==1 && i[1]==1 && i[2]==0){score=-10;}//1 1 0
        if (i[0]==0 && i[1]==1 && i[2]==1){score=-10;}//0 1 1
        if (i[0]==1 && i[1]==0 && i[2]==1){score=-10;}//1 0 1

        //score -1
        if (i[0]==0 && i[1]==1 && i[2]==0){score=-1;}//0 1 0
        if (i[0]==0 && i[1]==0 && i[2]==1){score=-1;}//0 0 1
        if (i[0]==1 && i[1]==0 && i[2]==0){score=-1;}//1 0 0



        if (i[0]==0 && i[1]==0 && i[2]==0){score=0;}// 0 0 0

        //score 0

        if (i[0]==2 && i[1]==0 && i[2]==1){score=0;}// 2 0 1
        if (i[0]==1 && i[1]==0 && i[2]==2){score=0;}// 1 0 2
        if (i[0]==0 && i[1]==1 && i[2]==2){score=0;}// 0 1 2
        if (i[0]==2 && i[1]==1 && i[2]==0){score=0;}// 2 1 0

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

    public int calculateColumn(Cell[] [] cellsGameField,int column){
        int score=0;
        int[] line = new int[cellsGameField.length];

        for (int i = 0; i <cellsGameField.length ; i++) {

            Cell cell = cellsGameField[i][column];

            line[i]=cell.getContent();

        }

        score=calculateLineVersion2(line,score);

        return score;
    }

    public int calculateRow(Cell[] [] cellsGameField,int row){
        int score = 0;
        int[] line = new int[cellsGameField.length];

        for (int j = 0; j <cellsGameField.length ; j++) {

            Cell cell = cellsGameField[row][j];

            line[j]=cell.getContent();

        }

        score=calculateLineVersion2(line,score);

        return score;
    }

    public int calculateDiagonal(Cell[] [] cellsGameField){
        int score=0;
        int count=0;
        int[] line = new int[cellsGameField.length];

        for (int i = 0; i <cellsGameField.length ; i++) {

            for (int j = 0; j <cellsGameField.length ; j++) {

                if (i==j){

                    Cell cell = cellsGameField[i][j];
                    line[count]=cell.getContent();
                    count+=1;

                }
            }

        }

        score=calculateLineVersion2(line,score);
        return score;
    }


    public int calculateReverseDiagonal(Cell[] [] cellsGameField){
        int score=0;

        int[] line = new int[cellsGameField.length];
        for (int i = 0; i <cellsGameField.length ; i++) {

            for (int j = 0; j <cellsGameField.length ; j++) {
                int diagonal= i+j;
                if (diagonal== (cellsGameField.length-1) ){
                    Cell cell = cellsGameField[i][j];
                    line[i]=cell.getContent();


                }

            }

        }

        score=calculateLineVersion2(line,score);
        return score;
    }




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
