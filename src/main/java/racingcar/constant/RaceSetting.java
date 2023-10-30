package racingcar.constant;

public enum RaceSetting {
    MIN_MOVE_NUMBER(4),
    MOVE_NUMBER(1),
    MAX_CAR_NAME_LENGTH(4);

    private final int value;

    RaceSetting(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
