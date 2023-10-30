package racingcar.constant.range;

public enum CarNameRange {
    MIN_LENGTH(1),
    MAX_LENGTH(5);

    private final int value;

    CarNameRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
