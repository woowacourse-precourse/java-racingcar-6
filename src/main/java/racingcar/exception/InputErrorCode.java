package racingcar.exception;

public enum InputErrorCode {
    INVALID_CAR_NAME_SIZE("자동차 이름은 5글자 초과할 수 없습니다.");

    private final String message;

    InputErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
