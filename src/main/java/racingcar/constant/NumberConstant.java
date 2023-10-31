package racingcar.constant;

public enum NumberConstant {
    NAME_LENGTH_MIN_SIZE(1),
    NAME_LENGTH_MAX_SIZE(5),
    CAR_COUNT_MIN_SIZE(2),
    INPUT_MIN_NUMBER(1),
    STANDARD_MOVE_NUMBER(4),
    RANDOM_MIN_NUMBER(0),
    RANDOM_MAX_NUMBER(9);
    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
