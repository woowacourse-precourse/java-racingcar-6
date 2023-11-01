package racingcar.model.rule;

public enum RuleErrorMessage {
    EMPTY_NAME("Name is Empty"),
    WRONG_SIZE_OF_NAME("Wrong Size Of Name"),
    DUPLICATED_NAME("Duplicated Name : ");

    private final String message;

    RuleErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(String detail) {
        return message + detail;
    }
}
