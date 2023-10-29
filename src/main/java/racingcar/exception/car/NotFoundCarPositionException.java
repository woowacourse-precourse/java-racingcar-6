package racingcar.exception.car;

public class NotFoundCarPositionException extends IllegalArgumentException {

    public NotFoundCarPositionException(String message) {
        super(message);
    }
}
