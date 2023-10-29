package racingcar.exceptions.argument;

public class InvalidCarNameTypeException extends IllegalArgumentException {

    private static final String INVALID_CAR_NAME_MESSAGE = "자동차 이름은 영문이어야 합니다.";

    public InvalidCarNameTypeException() {
        super(INVALID_CAR_NAME_MESSAGE);
    }
}
