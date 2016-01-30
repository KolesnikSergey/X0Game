/**
 * Created by DsergiyenkoN on 29.01.2016.
 */
public class DisplayGameField {
    private static boolean tempBool;
    static void printField(boolean[][] field, int N){

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (field[i][j]==true) {System.out.print("X | "); }
                else if (field[i][j]==false) System.out.print("0 | ");
                else System.out.println(":(");
                //System.out.print(field[i][j] + " ");
            }
            System.out.println();
            for (int j=0; j<N; j++) {
                System.out.print("---");
            }
            System.out.println("--");
        }
    }
}
