package racingcar.controller.constants;

public enum GlobalConstants {
    THRESHOLD_VALUE(4),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9);

    private final Integer value;

    GlobalConstants(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
