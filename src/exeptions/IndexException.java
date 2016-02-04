package exeptions;

/**
 * Created by Vadim on 03.02.2016.
 */
public class IndexException extends Throwable {

    public void printMessage() {
        System.out.println(message);
    }

    private String message;
    public IndexException(String message){
        this.message = message;
    }

}
