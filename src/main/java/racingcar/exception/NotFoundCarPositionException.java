package racingcar.exception;

public class NotFoundCarPositionException extends IllegalArgumentException {

    public NotFoundCarPositionException(String message) {
        super(message);
    }
}
