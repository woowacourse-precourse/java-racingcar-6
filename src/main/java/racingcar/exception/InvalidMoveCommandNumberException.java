package racingcar.exception;

public final class InvalidMoveCommandNumberException extends IllegalArgumentException {
    public static final String INVALID_MOVE_COMMAND_NUMBER_EXCEPTION_MESSAGE = "MoveCommand로 입력될 수 있는 것은 0~9 범위의 숫자입니다.";

    public InvalidMoveCommandNumberException() {
        super(INVALID_MOVE_COMMAND_NUMBER_EXCEPTION_MESSAGE);
    }
}
