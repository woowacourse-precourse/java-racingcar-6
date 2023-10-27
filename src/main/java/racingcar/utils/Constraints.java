package racingcar.utils;

public enum Constraints {
    MAX_SIZE(5),
    MIN_NUM(0),
    MAX_NUM(9),
    FORWARD_STANDARD(4);

    private final int value;

    Constraints(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}