package racingcar.tdd.config;

public enum RacingConfig {
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

    RacingConfig(int value) {
        this.value = value;
    }

    RacingConfig(String content) {
        this.content = content;
    }

    public int getValue() {
        return value;
    }

    public String getContent() {
        return content;
    }
}