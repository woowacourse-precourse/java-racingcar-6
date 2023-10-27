package racingcar.game.exception;

public class IllegalNullTypeException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "입력값은 존재해야 합니다. 프로그램을 종료합니다.";

    public IllegalNullTypeException() {
        super(DEFAULT_MESSAGE);
    }
}
