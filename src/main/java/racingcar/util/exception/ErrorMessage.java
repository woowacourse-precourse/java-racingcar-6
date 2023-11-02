package racingcar.util.exception;

public enum ErrorMessage {
    EMPTY_INPUT("Input can't be empty."),
    LESS_THAN_ONE("Input should be more than zero."),
    NOT_INTEGER("Input should be integer."),
    MORE_THAN_FIVE_CHARACTER("Car names should be less than five characters."),
    DUPLICATED_NAME("Each car has to have unique name.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
