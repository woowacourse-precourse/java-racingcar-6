package racingcar.constant;

public enum PositionConstant {
    LOW_BOUND(0),
    HIGH_BOUND(9),
    FORWARD_THRESHOLD(4);

    private final int value;

    PositionConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
