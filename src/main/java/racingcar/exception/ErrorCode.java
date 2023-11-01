package racingcar.exception;

public enum ErrorCode {
    CAR_NAME_WITHIN_FIVE_LETTERS("자동차 이름은 5글자 이내이어야 합니다.");

    private final String message;

    ErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
