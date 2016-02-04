package model;


import exeptions.CellNotEmptyExeption;
import exeptions.NoFreeCellsException;
import minmax.minmax.MinMax;
import minmax.cell.Cell;

/**
 * Created by kolesnik_s on 28.01.16.
 */
public class Computer extends Player {
    final int COMPUTER_SIGN =2;




    @Override
    protected void getCordinates (int [] [] gameField) throws CellNotEmptyExeption, NoFreeCellsException {
        MinMax minMax= new MinMax();
        Cell cell = new Cell();

        cell = minMax.calculateMove(gameField,COMPUTER_SIGN);
        super.cordinateA=cell.getCordinateA();
        super.cordinateB=cell.getCordinateB();

        if (gameField[super.cordinateA][super.cordinateB]!= 0){

            throw new CellNotEmptyExeption("computer try to place sign in cell that is not empty");
        }

    }

    @Override
    public void move(int[][] gameField) throws NoFreeCellsException{


        try {
            this.getCordinates(gameField);
        } catch (CellNotEmptyExeption cellNotEmptyExeption) {
            cellNotEmptyExeption.printStackTrace();
        }


        super.placeSighn(gameField, COMPUTER_SIGN);


}
}
