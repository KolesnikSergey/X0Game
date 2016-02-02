/**
 * Created by DsergiyenkoN on 29.01.2016.
 */
public class CheckWin { // 5 = 0 won, -5 = X won, 0 - none; 2 - draw
    static int check(int[][] field){ //N = how long is the line

        final int n = 3;

        for (int i=0; i<n-1; i++){ //chekcing rows
            for (int j=0; j<n-1; j++) {
                if (field[i][j]==0) break;
                if (field[i][j]!=field[i][j+1]){
                    break;
                } else if (j==n-2){
                    if (field[i][j]==1) return 5;
                    else return -5;
                }}}

        for (int i=0; i<n; i++){ //checking columns
            for (int j=0; j<n-1; j++) {
                if (field[j][i]==0) break;
                if (field[j][i]!=field[j+1][i]){
                    break;
                } else if (j==n-2){
                    if (field[j][i]==1) return 5;
                    else return -5;
                }}}

        for (int i=0;i<n-1; i++){
            if (field[i][i]==0) break;
            if  (field[i][i]!=field[i+1][i+1]){
                break;
            } else if (i==n-2){
                if (field[i][i]==1) return 5;
                else return -5;
            }}

        for (int i=n-1;i>=1; i--){
            if (field[i][n-i-1]==0) break;
            if  (field[i][n-i-1]!=field[i-1][n-i]){
                break;
            } else if (i==1){
                if (field[i][n-i-1]==1) return 5;
                else return -5;
            }}


        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                if ((field[i][j]!=1)&&(field[i][j]!=-1)){
                    return 0;

                }}}
        return 2;
    }

    static int assess(boolean[][] field, boolean player, int lastCell){ //5 = true win, -5=false win, 2 = draw, 0 = none
        int temp = 0;
        return -7;

    }
}