package exception;

public class WrongInputException extends IllegalArgumentException {
    public WrongInputException(String msg) {
        super(msg);
    }
}