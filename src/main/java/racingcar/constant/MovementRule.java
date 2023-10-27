package racingcar.constant;

public enum MovementRule {
    FORWARD_MINIMUM_VALUE(4);

    private final int value;

    MovementRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}