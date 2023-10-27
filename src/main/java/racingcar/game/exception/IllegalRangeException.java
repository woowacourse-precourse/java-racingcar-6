package racingcar.game.exception;

public class IllegalRangeException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE =
            "수의 범위는 " + Integer.MIN_VALUE + "이상" + Integer.MAX_VALUE + "이하여야 합니다. 프로그램을 종료합니다.";

    public IllegalRangeException() {
        super(DEFAULT_MESSAGE);
    }
}
