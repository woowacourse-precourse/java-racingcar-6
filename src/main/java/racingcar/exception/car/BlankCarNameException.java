package racingcar.exception.car;

public class BlankCarNameException extends IllegalArgumentException {
    private static final String REQUEST_CAR_NAME_INPUT_MESSAGE = "자동차 이름을 입력하세요.";

    public BlankCarNameException() {
        super(REQUEST_CAR_NAME_INPUT_MESSAGE);
    }
}
