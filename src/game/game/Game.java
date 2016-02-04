package game.game;

import game.checkWin.CheckWin;
import game.displaygame.DisplayGameField;
import model.Computer;
import model.Human;
import model.Player;

/**
 * Created by kolesnik_s on 28.01.16.
 */
public class Game {
    private int [][] gameField ;
    private Player human;
    private Player computer;
    private CheckWin checkWin;
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
        checkWin = new CheckWin();
        displayGameField = new DisplayGameField();
        /**
         * Initialize first player move in future
         * it can be some random value.
         */
        displayGameField.printField(gameField);
        while (checkWin.checkGame(gameField)!= true) {


            human.move(gameField);
            displayGameField.printField(gameField);

            if (checkWin.checkGame(gameField)==true) {
                displayGameField.printField(gameField);
                break;
            }

            computer.move(gameField);
            displayGameField.printField(gameField);

            if (checkWin.checkGame(gameField)==true) {
                displayGameField.printField(gameField);
                break;
            }

        }






    }
}
