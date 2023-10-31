package racingcar.constant;

public enum FixedNumber {
    ROUND_SLEEP_MILLISECONDS(1000),
    MIN_RACING_CAR_COUNT (2),
    MAX_RACING_CAR_COUNT(5),
    MIN_ROUND_COUNT(1),
    MAX_ROUND_COUNT (30),
    MAX_NAME_LENGTH(5),
    MIN_MOVING_FORWARD(4),
    MIN_RANDOM_NUMBER (0),
    MAX_RANDOM_NUMBER(9),
    ;

    FixedNumber(int value) {
        this.value = value;
    }

    private final int value;

    public int getValue() {
        return value;
    }
}
