package racingcar.constant;

public enum CarValue {
    CAR_MOVE_MINIMUM_RANGE(0),
    CAR_MOVE_MAXIMUM_RANGE(9),
    CAR_NAME_MAXIMUM_RANGE(5);


    private final int value;

    CarValue(int value) {
        this.value = value;

    }

    public int getValue() {
        return value;
    }
}
