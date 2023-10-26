package racingcar.utils;

public enum Constraints {
    MAX_SIZE(5);

    private final int value;

    private Constraints(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
