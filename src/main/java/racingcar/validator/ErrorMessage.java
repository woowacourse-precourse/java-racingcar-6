package racingcar.validator;

public enum ErrorMessage {
    INVALID_NULL("값을 입력해 주세요."),
    INVALID_SEPARATOR("구분자는 (%s)이며, 경기는 2명 이상으로 진행됩니다."),
    DUPLICATE_NAME("이름에 중복이 있습니다."),
    INVALID_LENGTH("이름은 %d자 이하여야 합니다."),
    INVALID_INTEGER("정수를 입력해 주세요."),
    INVALID_POSITIVE("이동 횟수는 양의 정수여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String formatMessage(Object... args) {
        return String.format(message, args);
    }
}
