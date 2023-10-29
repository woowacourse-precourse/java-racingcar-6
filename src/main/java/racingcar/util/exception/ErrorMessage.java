package racingcar.util.exception;

public enum ErrorMessage {
    EMPTY_NUMBER("Input can't be empty."),
    LESS_THAN_ONE("Input should be more than zero."),
    NOT_INTEGER("Input should be integer.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
