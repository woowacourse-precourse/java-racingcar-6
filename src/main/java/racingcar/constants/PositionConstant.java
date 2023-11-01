package racingcar.constants;

public enum PositionConstant {
    VALUE_LOW_BOUND(0),
    VALUE_HIGH_BOUND(9),
    FORWARD_THRESHOLD(4);

    private final int value;

    PositionConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}