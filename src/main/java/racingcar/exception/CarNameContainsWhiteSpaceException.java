package racingcar.exception;

public class CarNameContainsWhiteSpaceException extends IllegalArgumentException {

    private static final String messageFormat = "자동차 이름 (%s)에 공백이 포함되었습니다.";

    public CarNameContainsWhiteSpaceException(String invalidName) {
        super(String.format(messageFormat, invalidName));
    }
}
