import java.util.Scanner;

/**
 * Created by kolesnik_s on 28.01.16.
 */
public class Human extends Player {

    public Human() {
        setMashine(false);
    }

    @Override
    public boolean [][] setMoveToGameField(boolean [][] gameField, int maxValue){
        int firstCoordinate, secondCoordinate;

        firstCoordinate = setHumanCoordinates(maxValue, "A");
        secondCoordinate = setHumanCoordinates(maxValue, "B");

        gameField[firstCoordinate][secondCoordinate] = true;
        return gameField;
    }

    private int setHumanCoordinates(int fieldSize, String coordinateName) {
        int localCoordinate;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Set "+coordinateName+" coordinate:");
        localCoordinate = keyboard.nextInt();
        if(localCoordinate != fieldSize || localCoordinate == 0) {
            System.out.println("Coordinate is out of game field size!!!");
            return 0;
            //return some exception
        }
        return localCoordinate;
    }
}
