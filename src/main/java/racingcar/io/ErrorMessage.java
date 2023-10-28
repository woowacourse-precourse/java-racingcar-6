package racingcar.io;

public enum ErrorMessage {
    CAR_NAME_LENGTH_EXCEPTION("자동차 이름은 5글자 이하입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
