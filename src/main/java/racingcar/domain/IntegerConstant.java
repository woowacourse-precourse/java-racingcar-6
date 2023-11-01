package racingcar.domain;

public enum IntegerConstant {

    MAX_LENGTH(5),
    INITIAL_POSITION(0),
    MOVING_CONDITION(4),
    CAR_NAME_MAX_LENGTH(5),
    MIN_CAR_NUMBER(1),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    MAX_CAR_POSITION(0),
    MIN_VALUE(0);

    private final int value;

    IntegerConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
