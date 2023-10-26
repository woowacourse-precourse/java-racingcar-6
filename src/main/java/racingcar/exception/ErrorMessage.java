package racingcar.exception;

public enum ErrorMessage {
    NOT_INTEGER("[ERROR] 숫자만 입력가능합니다."),
    LONG_NAME("[ERROR]이름 길이가 너무 깁니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
