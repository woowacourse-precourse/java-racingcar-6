package racingcar.exception;

public enum ErrorMessage {
    INVALID_LENGTH("Car name's length is empty or longer than 5"),
    DUPLICATE_NAME("Car name is duplicated."),
    INVALID_NUMBER("Number of move should be non-negative integer");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
