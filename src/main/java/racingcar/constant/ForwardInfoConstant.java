package racingcar.constant;

public enum ForwardInfoConstant {
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    REFERENCE_VALUE_MOVING_FORWARD(4);

    private int value;

    private ForwardInfoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
