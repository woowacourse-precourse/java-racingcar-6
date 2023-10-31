package racingcar.util;

public class ErrorException extends IllegalArgumentException {

    public ErrorException(String errorMessage) {
        super(errorMessage);
    }
}
