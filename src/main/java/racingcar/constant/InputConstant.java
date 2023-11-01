package racingcar.constant;

public enum InputConstant {
    CAR_NAME_HIGH_BOUND(5),
    TRAIL_LOW_BOUND(0);

    private final int value;

    InputConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
