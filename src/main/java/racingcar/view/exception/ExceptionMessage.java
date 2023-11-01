package racingcar.view.exception;

public enum ExceptionMessage {

    NAME_LENGTH_EXCEPTION("이름 길이가 잘못되었습니다."),
    NAME_VALUE_BLANK_EXCEPTION("공백이 있으면 안 됩니다."),
    DUPLICATE_NAME_EXCEPTION("같은 이름이 있으면 안 됩니다."),
    PLAY_COUNT_VALUE_EXCEPTION("횟수는 양수여야 합니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
