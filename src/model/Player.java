package model;

import exeptions.CellNotEmptyExeption;
import exeptions.IndexException;
import exeptions.InvalidDataExeption;

/**
 * Created by kolesnik_s on 28.01.16.
 */
abstract public class Player {
    int cordinateA;
    int cordinateB;



    protected abstract void getCordinates(int [][] gameField) throws IndexException,CellNotEmptyExeption,InvalidDataExeption ;

    public abstract void move(int[] [] gameField) throws InvalidDataExeption;


    protected void placeSighn(int [][] gameField, int sign) {


        gameField[this.cordinateA][this.cordinateB] = sign;
    }

}
