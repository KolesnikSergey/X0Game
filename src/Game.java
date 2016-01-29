/**
 * Created by kolesnik_s on 28.01.16.
 */
public class Game {
    private char[][] gameField;
    private Player human;
    private Player computer;
    private int fieldSize;

    public Game(int size) {
        char fieldOfGame[][] = new char[size][size];
        setFieldSize(size);
        this.gameField = fieldOfGame;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    /**
     * getMaxCoordinateSize - calculate max coordinate
     *                        value that player can enter
     * @return int - max coordinaye value as fieldSize - 1
     */
    public int getMaxCoordinateSize() {
        return getFieldSize() - 1;
    }

    public void startGame() {
        boolean tmpWin = false;/*temporary for testing*/

        human = new Human();
        computer = new Computer();
        /**
         * Initialize first player move in future
         * it can be some randon value.
         */
        human.nextMove();

        while( !tmpWin/*future checkWin() method */ ){
            if(!human.isPlayerMove()) {
                computer.setMoveToGameField(gameField, getMaxCoordinateSize());
                human.nextMove();
            } else if(!computer.isPlayerMove()) {
                human.setMoveToGameField(gameField, getMaxCoordinateSize());
                computer.nextMove();
            } else {
                System.out.println("Both Players don't have move!!!");
                //throw ecxeption somthing wrong both pleyers are moving
            }
            //future printGameField()
            tmpWin = true;/*temporary for testing*/
        }

    }
}
