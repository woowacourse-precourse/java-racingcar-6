package racingcar.config;

public enum GameRange {
    MIN_RANGE_VALUE(0),
    MAX_RANGE_VALUE(9);

    private final int value;

    GameRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
