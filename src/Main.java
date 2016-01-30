public class Main {

    public static void main(String[] args) {
	// write your code here
        final int FIELD_SIZE = 3;

        Game x0Game = new Game(FIELD_SIZE);


        boolean[][]testField = {
                {true, false, true, false},
                {false, true, true, false},
                {true, true, false, true},
                {true, true, false, true}
        };



        boolean[][] testField1 = new boolean[][]{
                {true, false, true},
                {true, true, false},
                {false, false, false},
        };

        // {
//                {0.0, 0.1, 0.2},
//                {1.0, 1.1, 1.2},
//                {2.0, 2.1, 2.2}
//        };

        //System.out.println(testField[0][1]);


        DisplayGameField.printField(testField1, FIELD_SIZE);
        System.out.println();
        System.out.println(CheckWin.check(testField1,3));


        System.exit(5);



        x0Game.startGame();

    }
}
