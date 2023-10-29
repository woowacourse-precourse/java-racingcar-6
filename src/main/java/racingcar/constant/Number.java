package racingcar.constant;

public enum Number {
    CAR_NAME_LENGTH(5),
    MOVE_THRESHOLD(4),
    MIN_CARS_LENGTH(2);

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
