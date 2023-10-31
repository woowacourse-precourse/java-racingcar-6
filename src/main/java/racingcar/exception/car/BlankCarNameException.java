package racingcar.exception.car;

public class BlankCarNameException extends IllegalArgumentException {
    private static final String BLANK_NAME_MESSAGE = "자동차 이름에 공백만 있을 수 없습니다.";

    public BlankCarNameException() {
        super(BLANK_NAME_MESSAGE);
    }
}
