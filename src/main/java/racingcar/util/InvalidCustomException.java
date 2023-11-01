package racingcar.util;

public class InvalidCustomException extends IllegalArgumentException {
    public InvalidCustomException(String message) {
        super(message);
    }
}