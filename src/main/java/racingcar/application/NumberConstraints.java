package racingcar.application;

public enum NumberConstraints {

    MAX_NUMBER(9),
    MIN_NUMBER(0),
    MINIMUM_MOVABLE_NUMBER(4);

    private final int value;

    NumberConstraints(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
