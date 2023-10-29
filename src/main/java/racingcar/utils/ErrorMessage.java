package racingcar.utils;

public enum ErrorMessage {
    RACING_CAR_NAME_DOES_NOT_BLANK("The name of a racing car cannot be blank."),
    RACING_CAR_NAME_TOO_LONG("The name of a racing car can be up to 5 characters long."),
    TRY_COUNT_DOES_NOT_BLANK("Input cannot be blank."),
    TRY_COUNT_MUST_BE_INTEGER("Input must be an integer."),
    TRY_COUNT_MUST_BE_POSITIVE_INTEGER("TryCount must be an positive integer.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
