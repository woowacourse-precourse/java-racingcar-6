package racingcar.constant;

public enum ExceptionMessage {
    NOT_HAVE_DELIMITER("입력된 값에 \",\"가 없습니다."),
    NOT_AVAILABLE_STRING("숫자만 입력해 주세요"),
    NAME_IS_BLANK("이름이 입력되지 않았습니다.");

    private static final String ERROR = "[ERROR]";
    private final String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
