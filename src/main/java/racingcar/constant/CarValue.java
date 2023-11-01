package racingcar.constant;

public enum CarValue {
    CAR_MOVE_MINIMUM_RANGER(0),
    CAR_MOVE_MAXIMUM_RANGER(9),
    CAR_NAME_MAXIMUM_RANGER(5);


    private final int value;

    CarValue(int value) {
        this.value = value;

    }

    public int getValue() {
        return value;
    }
}
