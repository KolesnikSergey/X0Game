/**
 * Created by kolesnik_s on 28.01.16.
 */
abstract class Player {
    int cordinateA;
    int cordinateB;



    protected abstract void getCordinates(int [][] gameField);

    public abstract void move(int[] [] gameField);


    protected void placeSighn(int [][] gameField, int sign){

        gameField[this.cordinateB][this.cordinateA] = sign;
    }

}
