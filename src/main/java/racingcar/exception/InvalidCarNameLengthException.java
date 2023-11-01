package racingcar.exception;

public class InvalidCarNameLengthException extends IllegalArgumentException{
    public InvalidCarNameLengthException(String exceptionHandlingCode) {
        super(exceptionHandlingCode);
    }
}
