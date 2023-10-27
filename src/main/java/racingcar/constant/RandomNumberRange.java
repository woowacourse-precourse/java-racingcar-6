package racingcar.constant;

public enum RandomNumberRange {
    START_INCLUSIVE(0),
    END_INCLUSIVE(9);

    private final int value;

    RandomNumberRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
