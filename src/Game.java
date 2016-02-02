import game.checkWin.ChekWin;

/**
 * Created by kolesnik_s on 28.01.16.
 */
public class Game {
    private int [][] gameField ;
    private Player human;
    private Player computer;
    private ChekWin chekWin;
    private DisplayGameField displayGameField;

    public Game(int size) {

        this.gameField = new int [size][size];

    }

    /**
     * getMaxCoordinateSize - calculate max coordinate
     *                        value that player can enter
     * @return int - max coordinaye value as fieldSize - 1
     */



    public void startGame() {
        boolean tmpWin = false;/*temporary for testing*/

        human = new Human();
        computer = new Computer();
        chekWin = new ChekWin();
        displayGameField = new DisplayGameField();
        /**
         * Initialize first player move in future
         * it can be some random value.
         */

        while (chekWin.checkGame(gameField)!= true) {

            displayGameField.printField(gameField);
            human.move(gameField);
            if (chekWin.checkGame(gameField)==true) {
                displayGameField.printField(gameField);
                break;
            }
            displayGameField.printField(gameField);
            computer.move(gameField);

        }






    }
}
