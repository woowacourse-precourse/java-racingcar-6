package racingcar.config;

public enum MoveThreshold {
    MIN_THRESHOLD(4);

    private final int value;

    MoveThreshold(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
