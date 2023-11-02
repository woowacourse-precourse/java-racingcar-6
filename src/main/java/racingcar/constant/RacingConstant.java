package racingcar.constant;

public enum RacingConstant {
    MIN_DASH_CONDITION(4),
    MAX_NAME_LENGTH(5);
    private final int value;

    RacingConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
