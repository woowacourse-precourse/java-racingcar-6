package enums;

public enum ErrorMessages {

    MAX_LENGTH_ERROR("String index out of range: 5");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
