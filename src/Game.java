import java.util.ArrayList;

/**
 * Created by kolesnik_s on 28.01.16.
 */
public class Game {
    private boolean[][] gameField;
    private Player human;
    private Player computer;
    private int fieldSize;

    public Game(int size) {
        boolean fieldOfGame[][] = new boolean[size][size];
        setFieldSize(size);
        this.gameField = fieldOfGame;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public void startGame() {
        boolean tmpWin = false;/*temporary for testing*/

        ArrayList <boolean[][]> listOfGameFields = new ArrayList<boolean[][]>(2);
        human = new Human();
        computer = new Computer();
        /**
         * Initialize first players moves in future
         * it can be some randon value.
         */
        human.setPlayerMove(true);
        computer.setPlayerMove(false);

        while( !tmpWin/*future checkWin() method */ ){
            if(!human.isPlayerMove()) {
                computer.setMoveToGameField(gameField, getFieldSize());
                computer.setPlayerMove(false);
                human.setPlayerMove(true);
            } else if(!computer.isPlayerMove()) {
                human.setMoveToGameField(gameField, getFieldSize());
                human.setPlayerMove(false);
                computer.setPlayerMove(true);
            } else {
                System.out.println("Both Players don't have move!!!");
                //throw ecxeption somthing wrong both pleyers are moving
            }
            //future printGameField()
            listOfGameFields.add(gameField);/*Save all moves to arrayList maybe we need it to analize in computer move*/
            tmpWin = true;/*temporary for testing*/
        }

    }
}
