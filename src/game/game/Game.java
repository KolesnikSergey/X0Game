package game.game;

import exeptions.InvalidDataException;
import exeptions.NoFreeCellsException;
import game.checkWin.CheckWin;
import game.displaygame.DisplayGameField;
import model.Computer;
import model.Human;
import model.Player;

import java.util.Scanner;

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
         */boolean gameOver =false;
        displayGameField.printField(gameField);
        do{



            try {
                human.move(gameField);
            } catch (InvalidDataException invalidDataException) {
                gameOver=true;
            } catch (NoFreeCellsException e) {
                gameOver=true;
            }


            if (checkWin.checkGame(gameField)==true) {
                    gameOver=true;
                displayGameField.printField(gameField);

                }else {


                try {
                    computer.move(gameField);
                } catch (InvalidDataException invalidDataException) {
                    gameOver=true;
                    displayGameField.printField(gameField);
                } catch (NoFreeCellsException e) {
                    gameOver=true;
                }

                displayGameField.printField(gameField);

                    if (checkWin.checkGame(gameField)==true){
                        gameOver=true;
                    }
                }


            if (gameOver == true) {
                int player=1;

                if(checkWin.checkPlayer(gameField,player)){
                    System.out.println("Player 1 win");}

                player=2;
                if(checkWin.checkPlayer(gameField,player)) {
                    System.out.println("Player 2 win");
                }

                System.out.println("Game over! Play again \n 1- yes \n 2 - no");

                Scanner keyboard = new Scanner(System.in);

                int choise = keyboard.nextInt();
                if (choise == 1) {
                    for (int i = 0; i < gameField.length; i++) {
                        for (int j = 0; j < gameField.length; j++) {
                            gameField[i][j]=0;
                        }
                    }
                    displayGameField.printField(gameField);
                    gameOver=false;
                }else {

                        System.out.println("Thank you for playing");
                    }


            }

        }while (!gameOver);






    }
}
