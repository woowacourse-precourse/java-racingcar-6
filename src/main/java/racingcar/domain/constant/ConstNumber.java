package racingcar.domain.constant;

public enum ConstNumber {

    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    MOVE_CRITERIA(4),
    CAR_NAME_MAX_LENGTH(5);

    private final int value;

    ConstNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
