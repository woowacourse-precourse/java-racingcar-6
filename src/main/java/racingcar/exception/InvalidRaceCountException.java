package racingcar.exception;

public class InvalidRaceCountException extends IllegalArgumentException{
    public InvalidRaceCountException(String exceptionHandlingCode) {
        super(exceptionHandlingCode);
    }
}
