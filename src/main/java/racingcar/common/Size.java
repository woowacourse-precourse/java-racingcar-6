package racingcar.common;

public enum Size {
    CAR_NAME(5),
    MOVING_BOUNDARY(4);

    private final int value;

    Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
