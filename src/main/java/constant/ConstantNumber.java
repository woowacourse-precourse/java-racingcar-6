package constant;

public enum ConstantNumber {
    MAX_NAME_LENGTH(5),
    MIN_NUMBER_RANGE(1),
    MAX_NUMBER_RANGE(9),
    MOVING_FORWARD(4),
    MOVE_DISTANCE(1),
    MIN_ATTEMPTS(1),
    DEFAULT_MAX_COUNT(0),
    INITIAL_MOVE_COUNT(0);

    private final int value;

    ConstantNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
