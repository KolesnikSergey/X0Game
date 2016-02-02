import java.util.Scanner;

/**
 * Created by kolesnik_s on 28.01.16.
 */
public class Human extends Player {


    @Override
    public void move(int[][] gameField) {
        this.getCordinates(gameField);
        int humanSign=1;
        this.placeSighn(gameField,humanSign);


    }

    @Override
    public void placeSighn(int[][] gameField, int sign) {
        super.placeSighn(gameField, sign);
    }

    @Override
    public void getCordinates(int [] [] gameField) {
    super.cordinateA = setHumanCoordinates(gameField.length,"A");
    super.cordinateB = setHumanCoordinates(gameField.length,"B");
    }



    private int setHumanCoordinates(int fieldSize, String coordinateName) {
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
