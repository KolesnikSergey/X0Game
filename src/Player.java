/**
 * Created by kolesnik_s on 28.01.16.
 */
abstract class Player {
    int cordinateA;
    int cordinateB;



    protected abstract void getCordinates(char [][] gameField);

    public abstract void move(char[] [] gameField);


    protected void placeSighn(char [][] gameField, char sign){

        gameField[this.cordinateB][this.cordinateA] = sign;
    }

}
