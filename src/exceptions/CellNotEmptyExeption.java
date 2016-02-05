package exceptions;

/**
 * Created by Vadim on 03.02.2016.
 */
public class CellNotEmptyExeption extends Throwable{

    private String message;

    public CellNotEmptyExeption(String message){
        this.message = message;

    }
    public void printMessage() {
        System.out.println(message);
    }
}
