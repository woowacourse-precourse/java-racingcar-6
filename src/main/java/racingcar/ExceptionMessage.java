package racingcar;

public enum ExceptionMessage {
    NAME_LENGTH_EXCEPTION("이름 길이가 잘못되었습니다."),
    NAME_VALUE_BLANK_EXCEPTION("공백이 있으면 안 됩니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
