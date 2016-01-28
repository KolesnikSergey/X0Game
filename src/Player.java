/**
 * Created by kolesnik_s on 28.01.16.
 */
abstract class Player {
    private boolean isMashine;
    private boolean isPlayerMove;

    public boolean isPlayerMove() {
        return isPlayerMove;
    }

    public void setPlayerMove(boolean playerMove) {
        isPlayerMove = playerMove;
    }

    public boolean isMashine() {
        return isMashine;
    }

    public void setMashine(boolean mashine) {
        isMashine = mashine;
    }

    public abstract boolean[][] setMoveToGameField(boolean [][] gameField, int maxValue);
}
