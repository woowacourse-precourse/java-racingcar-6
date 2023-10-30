package racingcar;

public enum RandomNumberRange {
    MINIMUM_RANGE_VALUE(0),
    MAXIMUM_RANGE_VALUE(9);

    private final int value;

    private RandomNumberRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
