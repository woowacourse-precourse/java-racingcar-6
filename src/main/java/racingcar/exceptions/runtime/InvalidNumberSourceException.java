package racingcar.exceptions.runtime;

public class InvalidNumberSourceException extends RuntimeException {


    private final static String INVALID_NUMBER_SOURCE_MESSAGE = "숫자가 아닙니다.";

    public InvalidNumberSourceException() {
        super(INVALID_NUMBER_SOURCE_MESSAGE);
    }
}
