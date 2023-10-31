package racingcar.enums;

public enum Movement {
    MIN_MOVE_RANGE(0),
    MAX_MOVE_RANGE(9),
    MIN_MOVE_CONDITION(4);

    private final int value;

    Movement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
