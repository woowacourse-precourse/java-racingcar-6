package racingcar.constant;

public enum RandNumConstant {
    MIN_NUM_RANGE(0),
    MAX_NUM_RANGE(9);
    private final int value;

    RandNumConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
