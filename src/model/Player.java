package model;

import exceptions.CellNotEmptyExeption;
import exceptions.IndexException;
import exceptions.InvalidDataException;
import exceptions.NoFreeCellsException;

/**
 * Created by kolesnik_s on 28.01.16.
 */
abstract public class Player {
    int cordinateA;
    int cordinateB;



    protected abstract void getCordinates(int [][] gameField) throws IndexException, CellNotEmptyExeption, InvalidDataException, NoFreeCellsException;

    public abstract void move(int[] [] gameField) throws InvalidDataException,NoFreeCellsException;


    protected void placeSighn(int [][] gameField, int sign) {


        gameField[this.cordinateA][this.cordinateB] = sign;
    }

}
