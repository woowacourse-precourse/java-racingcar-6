package racingcar.exception;

public enum RacingCarException {
    NAME_LENGTH_EXCEPTION("[Error] 이름은 5자 이하만 가능합니다."),
    ATTEMPT_MINIMUM_COUNT_EXCEPTION("[Error] 시도할 횟수는 최소 1회 이상입니다."),
    ;

    private final String message;

    RacingCarException(String message) {
        this.message = message;
    }

    public void getException() throws IllegalArgumentException {
        throw new IllegalArgumentException(message);
    }
}
