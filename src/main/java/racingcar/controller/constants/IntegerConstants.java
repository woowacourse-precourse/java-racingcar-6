package racingcar.controller.constants;

public enum IntegerConstants {
    THRESHOLD_VALUE(4),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),

    STARTING_POINT(0),
    ONE_STEP(1),

    EMPTY(0);

    private final Integer value;

    IntegerConstants(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
