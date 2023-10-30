package racingcar.constant;

public enum RaceSetting {
    MIN_MOVE_NUMBER(4),
    MOVE_NUMBER(1);

    private final int value;

    RaceSetting(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
