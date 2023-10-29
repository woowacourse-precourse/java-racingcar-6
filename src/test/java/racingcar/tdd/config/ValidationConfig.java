package racingcar.tdd.config;

public enum ValidationConfig {
    INPUT_CAR_NAME_LENGTH_MIN(1),
    INPUT_CAR_NAME_LENGTH_MAX(100000),
    SPLIT_CAR_NAME_LENGTH_MIN(1),
    SPLIT_CAR_NAME_LENGTH_MAX(5),
    ATTEMPT_COUNT_MIN(1),
    ATTEMPT_COUNT_MAX(1000),
    CAR_NAME_SPLIT_DELIM(","),
    ERROR_CARS_MESSAGE_JOIN_DELIM(", ");

    private int value;
    private String content;

    ValidationConfig(int value) {
        this.value = value;
    }

    ValidationConfig(String content) {
        this.content = content;
    }

    public int getValue() {
        return value;
    }

    public String getContent() {
        return content;
    }
}