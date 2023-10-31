package exception;

public class WrongNameException extends IllegalArgumentException {
    public WrongNameException(String msg) {
        super(msg);
    }
}