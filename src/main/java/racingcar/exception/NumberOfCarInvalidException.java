package racingcar.exception;

public class NumberOfCarInvalidException extends IllegalArgumentException {

    private static final String exceptionMessage = "자동차는 2대 이상 있어야 합니다.";

    public NumberOfCarInvalidException() {
        super(exceptionMessage);
    }
}
