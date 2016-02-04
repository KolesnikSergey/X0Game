package model;

import exeptions.CellNotEmptyExeption;
import exeptions.IndexException;

import java.util.Scanner;

/**
 * Created by kolesnik_s on 28.01.16.
 */
public class Human extends Player {


    @Override
    public void move(int[][] gameField) {
        //int [] [] gameField =  new int[][];
        int count = 0;
        while (count < 3)
            try {
                this.getCordinates(gameField);
                count = 5;
            }catch (CellNotEmptyExeption cellNotEmptyExeption) {
                count += 1;
                cellNotEmptyExeption.printMessage();
                System.out.println("Player 1 left "+(3-count)+" tries ");
            }catch (IndexException indexException){
                count=3;
                indexException.printMessage();
            }


        if (count == 5) {
            int humanSign = 1;
            this.placeSighn(gameField, humanSign);
        } else {
            System.out.println("Game Over!!!");
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    gameField[i][j]=0;
                }
            }

        }


    }






    @Override
    public void placeSighn(int[][] gameField, int sign){

            super.placeSighn(gameField, sign);

    }

    @Override
    public void getCordinates(int [] [] gameField) throws CellNotEmptyExeption,IndexException  {
    super.cordinateA = setHumanCoordinates(gameField.length,"A");
    super.cordinateB = setHumanCoordinates(gameField.length,"B");
        if (gameField[super.cordinateA][super.cordinateB]!= 0){

            throw new CellNotEmptyExeption("Cell is not empty");
        }

    }



    private int setHumanCoordinates(int fieldSize, String coordinateName) throws IndexException {
        int localCoordinate = -1;
        int tryCount = 0;


        System.out.println("Set "+coordinateName+" coordinate:");
        while (tryCount < 3) {
            try {

                localCoordinate = readLine(fieldSize);
                tryCount=5;
            } catch (IndexException indexException) {
                tryCount+=1;
                indexException.printMessage();
                System.out.println("Player 1 left "+(3-tryCount)+" tries ");
            }

            }

        if (tryCount==3) {
            System.out.println("GAME OVER.");
            throw  new IndexException("Game Over");

            //some exception
        }
        return localCoordinate-1;
    }

    private  int readLine(int fieldSize)throws IndexException {

        Scanner keyboard = new Scanner(System.in);

        int localCoordinate = keyboard.nextInt();;

        if (localCoordinate > fieldSize || localCoordinate <= 0) {

            throw new IndexException("Coordinate is out of game field size.");
        }
        return localCoordinate;
    }
}
