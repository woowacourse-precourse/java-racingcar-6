package racingcar.game.exception;

public class IllegalBlankException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "입력값은 공백이 없어야 합니다. 프로그램을 종료합니다.";

    public IllegalBlankException() {
        super(DEFAULT_MESSAGE);
    }
}
