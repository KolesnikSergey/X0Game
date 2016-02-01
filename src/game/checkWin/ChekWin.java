package game.checkWin;

/**
 * Created by Vadim on 31.01.2016.
 */
public class ChekWin {

    public boolean checkGame(char[] [] gameField){
        if (this.chekPlayer(gameField, 'X')){
            System.out.println("X player WIN");
            return true;
        }else
        if (this.chekPlayer(gameField,'O')){
            System.out.println("O player Win");
            return true;
        }else return false;
    }

    public boolean chekPlayer(char[] [] gameField,char player){
        if (checkColumn(gameField,player) || checkRow(gameField,player) || checkDiagonal(gameField,player)){
            return true;
        }
        else return false;
    }

    private boolean checkColumn(char[] [] gameField, char player){
        boolean result=false;
        int[] column = new int[gameField.length];

        for (int j = 0; j <gameField.length ; j++) {

            for (int i = 0; i <gameField.length ; i++) {

                char sighn = gameField[i][j];// cheking for J  and  I

            if ( sighn == player ) column[j]+=1;
            }
            //System.out.println("column["+ (j+1) +"] ="+ column[j]);
        }

        for (int i = 0; i <gameField.length ; i++) {
            if (column[i]== gameField.length) {
                result=true;
            }
        }
        return result;}

    private boolean checkRow(char[] [] gameField, char player){
        boolean result=false;
        int[] row = new int[gameField.length];

        for (int i = 0; i <gameField.length ; i++) {

            for (int j = 0; j <gameField.length ; j++) {
                char sighn = gameField[i][j];
                if ( sighn == player ) row[i]+=1;
            }
            //System.out.println("row["+ (i+1) +"] ="+ row[i]);
        }

        for (int i = 0; i <gameField.length ; i++) {
            if (row[i]==gameField.length) result=true;
        }

        return  result;}



    private boolean checkDiagonal(char[] [] gameField, char player){
        boolean result=false;
        int diagonal = 0;
        int reverseDiagonal = 0;

        for (int i = 0; i <gameField.length ; i++) {

            for (int j = 0; j <gameField.length ; j++) {
                if (i==j){
                    char sighn = gameField[i][j];
                    if ( sighn == player ) diagonal+=1;
                }
                if ( ( j + j ) == (gameField.length-1) ){
                    char sighn = gameField[i][j];
                    if ( sighn == player ) reverseDiagonal+=1;
                }


            }

        }
        //System.out.println("diagonal ="+ diagonal);
        //System.out.println("reverseDiagonal ="+ reverseDiagonal);
        if ( (diagonal==gameField.length) || (reverseDiagonal==gameField.length) ){
            result=true;
        }
        return result;}
}
