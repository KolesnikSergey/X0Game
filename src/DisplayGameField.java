import minmax.cell.Cell;

/**
 * Created by Vadim on 31.01.2016.
 */
public class DisplayGameField {

    public void printField(int[] [] gameField){

      /*  gameField = new char[][]{
                {'O','O','X'},
                {' ',' ','X'},
                {'O','O','X'}
        }; */


        /*  Placing upper cordinates names */
        System.out.print("   ");
        for (int i = 0; i <gameField.length; i++) {
            System.out.print(" A"+(i+1));
            if (i<gameField.length-1) System.out.print("|");
        }
        System.out.println();
        System.out.println();

        /**/
        for (int i = 0; i < gameField.length; i++) {
            System.out.print("B" + (i+1)+" ");
            for (int j = 0; j <gameField.length; j++) {
                System.out.print(" "+gameField[i][j]);
                if (j<gameField.length-1){ System.out.print(" |");}
            }
            System.out.println();
            if(i<gameField.length-1)System.out.println("   ------------");
        }
        System.out.println();
    }

    public void printField(Cell[] [] gameField){

      /*  gameField = new char[][]{
                {'O','O','X'},
                {' ',' ','X'},
                {'O','O','X'}
        }; */


        /*  Placing upper cordinates names */
        System.out.print("   ");
        for (int i = 0; i <gameField.length; i++) {
            System.out.print(" A"+(i+1));
            if (i<gameField.length-1) System.out.print("|");
        }
        System.out.println();
        System.out.println();

        /**/
        for (int i = 0; i < gameField.length; i++) {
            System.out.print("B" + (i+1)+" ");
            for (int j = 0; j <gameField.length; j++) {
                System.out.print(" "+gameField[i][j].getContent());
                if (j<gameField.length-1){ System.out.print(" |");}
            }
            System.out.println();
            if(i<gameField.length-1)System.out.println("   ------------");
        }
        System.out.println();
    }
}
