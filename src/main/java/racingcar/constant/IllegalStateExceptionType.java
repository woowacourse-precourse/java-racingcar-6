package racingcar.constant;

public enum IllegalStateExceptionType implements ExceptionType<IllegalStateException> {

    NO_MORE_ATTEMPT_MESSAGE("모든 게임 시도 횟수를 사용했습니다."),
    GAME_NOT_ENDED_MESSAGE("아직 게임이 끝나지 않았습니다.");

    private final String message;

    IllegalStateExceptionType(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public IllegalStateException getException() {
        return new IllegalStateException(message);
    }
}
