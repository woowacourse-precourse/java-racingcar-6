package racingcar.domain.move;

public final class InvalidCoordinateException extends IllegalArgumentException {
    public static final String INVALID_COORDINATE_EXCEPTION = "최소 위치는 0 이상입니다.";

    public InvalidCoordinateException() {
        super(INVALID_COORDINATE_EXCEPTION);
    }
}
