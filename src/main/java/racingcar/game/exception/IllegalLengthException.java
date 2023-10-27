package racingcar.game.exception;

public class IllegalLengthException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "이름의 길이는 5자 이하 이어야만 합니다. 프로그램을 종료합니다.";

    public IllegalLengthException() {
        super(DEFAULT_MESSAGE);
    }
}
