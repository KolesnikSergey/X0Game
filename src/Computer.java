/**
 * Created by kolesnik_s on 28.01.16.
 */
public class Computer extends Player {

    @Override
    public char[][] setMoveToGameField(char [][] gameField, int maxValue) {
        //some actions
        alreadyMoved();
        return gameField;
    }
}
