package exeptions;

/**
 * Created by Vadim on 03.02.2016.
 */
public class IndexExeption extends Throwable {

    public void printMessage() {
        System.out.println(message);
    }

    private String message;
    public IndexExeption(String message){
        message = message;
    }

}
