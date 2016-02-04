package model;

import exeptions.CellNotEmptyExeption;
import exeptions.IndexExeption;
import game.displaygame.DisplayGameField;

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
            } catch (CellNotEmptyExeption cellNotEmptyExeption) {
                count += 1;
                cellNotEmptyExeption.printMessage();
                System.out.println("Player 1 left "+(3-count)+" tries ");
            }

        if (count == 5) {
            int humanSign = 1;
            this.placeSighn(gameField, humanSign);
        } else {
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    gameField[i][j]=0;
                }
            }
            System.out.println("Game Over!!!");
        }


    }






    @Override
    public void placeSighn(int[][] gameField, int sign){

            super.placeSighn(gameField, sign);

    }

    @Override
    public void getCordinates(int [] [] gameField) throws CellNotEmptyExeption  {
    super.cordinateA = setHumanCoordinates(gameField.length,"A");
    super.cordinateB = setHumanCoordinates(gameField.length,"B");
        if (gameField[super.cordinateA][super.cordinateB]!= 0){

            throw new CellNotEmptyExeption("Cell is not empty");
        }

    }



    private int setHumanCoordinates(int fieldSize, String coordinateName){
        int localCoordinate = -1;
        int tryCount = 3;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Set "+coordinateName+" coordinate:");
        while (tryCount > 0) {
            localCoordinate = keyboard.nextInt();
            if (localCoordinate > fieldSize || localCoordinate < 0) {
                System.out.println("Coordinate is out of game field size.");
                tryCount--;
                switch (tryCount) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Last try:");
                        break;
                    default:
                        System.out.println("Try again, left "+tryCount+" tries:");
                }
            } else {
                break;
            }
        }
        if (localCoordinate > fieldSize || localCoordinate < 0) {
            System.out.println("GAME OVER.");
            return -1;
            //some exception
        }
        return localCoordinate-1;
    }
}
