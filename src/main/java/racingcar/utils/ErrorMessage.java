package racingcar.utils;

public enum ErrorMessage {
    RACING_CAR_NAME_DOES_NOT_BLANK("The name of a racing car cannot be blank."),
    RACING_CAR_NAME_TOO_LONG("The name of a racing car can be up to 5 characters long.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
