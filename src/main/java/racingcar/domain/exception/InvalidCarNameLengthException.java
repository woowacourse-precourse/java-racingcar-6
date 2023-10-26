package racingcar.domain.exception;

public final class InvalidCarNameLengthException extends IllegalArgumentException {
    public static final String INVALID_CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "차 이름은 1~5자여야 합니다.";

    public InvalidCarNameLengthException() {
        super(INVALID_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
    }
}
