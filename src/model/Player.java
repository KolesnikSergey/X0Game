package model;

import exeptions.CellNotEmptyExeption;
import exeptions.IndexExeption;

/**
 * Created by kolesnik_s on 28.01.16.
 */
abstract public class Player {
    int cordinateA;
    int cordinateB;



    protected abstract void getCordinates(int [][] gameField) throws IndexExeption,CellNotEmptyExeption ;

    public abstract void move(int[] [] gameField)  ;


    protected void placeSighn(int [][] gameField, int sign) {


        gameField[this.cordinateA][this.cordinateB] = sign;
    }

}
