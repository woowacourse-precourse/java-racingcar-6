package racingcar.global.constants;

public enum NumberType {
    MAX_LENGTH_OF_NUMBER(5),
    MIN_CAR_SIZE(2),
    MIN_RACE_COUNT(1),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    MIN_FORWARD_THRESHOLD(4),
    INITIAL_POSITION(0);

    private final Integer value;

    NumberType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
