package minmax.Score;

import minmax.cell.Cell;

/**
 * Created by Vadim on 31.01.2016.
 */
public class CalculateScore {


    public int calculateScore(Cell[][] gameField, char player){

        int score=0;

        score += calculateColumn(gameField,0,player);
        score += calculateColumn(gameField,1,player);
        score += calculateColumn(gameField,2,player);

        score+=calculateRow(gameField,0,player);
        score+=calculateRow(gameField,1,player);
        score+=calculateRow(gameField,2,player);

        
        return score;
    }

    private int calculateColumn(Cell[] [] cellsGameField,int column, char player){

        int score = 0;

            for (int i = 0; i <cellsGameField.length ; i++) {

                char sighn = cellsGameField[i][column].getContent();

                if ( sighn == player ) score+=1;
            }
            //System.out.println("column["+ (j+1) +"] ="+ column[j]);

        return score;
    }

    private int calculateRow(Cell[] [] cellsGameField,int row, char player){

        int score = 0;

        for (int j = 0; j <cellsGameField.length ; j++) {

            char sighn = cellsGameField[row][j].getContent();

            if ( sighn == player ) score+=1;
        }
        //System.out.println("column["+ (j+1) +"] ="+ column[j]);

        return score;}
    }
