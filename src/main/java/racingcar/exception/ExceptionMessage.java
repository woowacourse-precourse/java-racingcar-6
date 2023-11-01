package racingcar.exception;

public enum ExceptionMessage {
    NOT_MUST_BE_NULL("입력 문자열은 null일 수 없습니다."),
    NOT_BLANK("입력 문자열 길이는 공백일 수 없습니다."),
    INVALID_MAX_LENGTH("입력 문자열의 길이는 %d이하만 가능합니다."),
    MUST_BE_DIGIT("숫자만 입력 가능합니다."),
    MUST_BE_POSITIVE("1이상의 양수만 입력 가능합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(final String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String format(final Object... args) {
        return String.format(message, args);
    }
}
