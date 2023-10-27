package racingcar;

public enum ExceptionMessage {
    NOT_HAVE_DELIMITER("입력된 값에 \",\"가 없습니다."),
    NOT_AVAILABLE_STRING("숫자만 입력해 주세요");

    private static final String ERROR = "[ERROR]";
    private final String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
