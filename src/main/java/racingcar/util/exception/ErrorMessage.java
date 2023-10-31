package racingcar.util.exception;

public enum ErrorMessage {
    INVALID_NAME("이름은 1 ~ 5자만 가능합니다."),
    NOT_INTEGER("정수가 아닙니다."),
    NOT_POSITIVE("양의 정수가 아닙니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
