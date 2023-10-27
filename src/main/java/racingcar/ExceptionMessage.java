package racingcar;

public enum ExceptionMessage {
    NOT_HAVE_DELIMITER("입력된 값에 \",\"가 없습니다.");

    private static final String ERROR = "[ERROR]";
    private final String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
