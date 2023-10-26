package racingcar.error;

public enum ErrorMessage {
    LONG_CAR_NAME("자동차 이름이 5글자를 초과합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
