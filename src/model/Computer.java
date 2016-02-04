package model;


import exeptions.CellNotEmptyExeption;
import exeptions.IndexExeption;
import minmax.minmax.MinMax;
import minmax.cell.Cell;

/**
 * Created by kolesnik_s on 28.01.16.
 */
public class Computer extends Player {
    final int COMPUTER_SIGN =2;




    @Override
    protected void getCordinates(int [] [] gameField) {
        MinMax minMax= new MinMax();
        Cell cell = new Cell();

        cell = minMax.calculateMove(gameField,COMPUTER_SIGN);
        super.cordinateA=cell.getCordinateA();
        super.cordinateB=cell.getCordinateB();
    }

    @Override
    public void move(int[][] gameField) {


        this.getCordinates(gameField);

        super.placeSighn(gameField, COMPUTER_SIGN);

    }
}
