/**
 * Created by DsergiyenkoN on 29.01.2016.
 */
public class CheckWin {
    static boolean check(boolean[][] field, int n){ //N = how long is the line
        boolean tempBool=false;

        for (int i=0; i<n; i++){ //chekcing rows
            for (int j=0; j<n-1; j++) {
                if (field[i][j]!=field[i][j+1]){
                    break;
                } else if (j==n-2){
                    return true;
                }

            }

        }
        for (int i=0; i<n; i++){ //checking columns
            for (int j=0; j<n-1; j++) {
                if (field[j][i]!=field[j+1][i]){
                    break;
                } else if (j==n-2){
                    return true;
                }

            }

        }

        for (int i=0;i<n-1; i++){
            if  (field[i][i]!=field[i+1][i+1]){
                break;
            } else if (i==n-2){
                return true;
            }

        }

        for (int i=n-1;i>=1; i--){
            if  (field[i][n-i-1]!=field[i-1][n-i]){
                break;
            } else if (i==1){
                return true;
            }

        }

        return false;
    }
}