/**
 * Created by kolesnik_s on 28.01.16.
 */
abstract class Player {
    private boolean isPlayerMove = false;

    public boolean isPlayerMove() {
        return isPlayerMove;
    }

    public void setPlayerMove(boolean playerMove) {
        isPlayerMove = playerMove;
    }

    public void alreadyMoved(){
        setPlayerMove(false);
    }

    public void nextMove() {
        setPlayerMove(true);
    }

    public abstract char[][] setMoveToGameField(char [][] gameField, int maxValue);
}
