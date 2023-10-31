package racingcar.enums;

public enum RacingConfig {
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    MAX_CAR_NAME_LENGTH(5),
    MOVE_CONDITION(4),
    MIN_CAR_COUNT(2);

    private final int value;

    RacingConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
