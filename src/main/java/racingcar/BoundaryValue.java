package racingcar;

public enum BoundaryValue {
    MIN_RANDOM(0),
    MAX_RANDOM(9),
    MOVE_LIMIT(4),
    MIN_CAR_COUNT(2),
    MAX_NAME_LENGTH(5),
    MIN_ROUND(1);

    private final int value;

    BoundaryValue(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
