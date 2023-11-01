package racingcar.exceptions.argument;

public class EmptyCarNameException extends IllegalArgumentException {

    private static final String MESSAGE = "자동차 이름은 빈 문자열이 될 수 없습니다.";

    public EmptyCarNameException() {
        super(MESSAGE);
    }
}
