package racingcar.model.constants;

public enum Rule {
    DELIMITER(0, ","),

    CAR_MIN_LENGTH(1, "1"),
    CAR_MAX_LENGTH(5, "5"),

    TRIAL_MIN_LENGTH(1, "1");

    private final int value;
    private final String message;

    Rule(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
