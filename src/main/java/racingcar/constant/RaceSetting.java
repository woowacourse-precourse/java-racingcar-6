package racingcar.constant;

public enum RaceSetting {
    MIN_MOVE_NUMBER(4),
    MOVE_NUMBER(1),
    MAX_CAR_NAME_LENGTH(5),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9);

    private final int value;

    RaceSetting(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
