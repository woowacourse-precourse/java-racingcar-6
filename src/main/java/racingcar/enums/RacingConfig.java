package racingcar.enums;

public enum RacingConfig {
    RANDOM_NUMBER_MIN(0),
    RANDOM_NUMBER_MAX(9),
    CAR_NAME_MAX_LENGTH(5),
    MOVE_CONDITION(4);

    private final int value;

    RacingConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
