package racingcar.common.exception;

public enum ErrorMessage {

    NULL_INPUT_STRING("Input String cannot be null."),
    EMPTY_INPUT_STRING("Input String cannot be empty or blank."),
    NAME_TOO_LONG("Name is too long."),
    NULL_NAME("Name cannot be null."),
    EMPTY_NAME("Name cannot be empty or blank."),
    DUPLICATED_NAME("Names cannot be duplicated.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
