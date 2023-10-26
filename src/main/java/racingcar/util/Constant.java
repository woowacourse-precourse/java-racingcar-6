package racingcar.util;

public enum Constant {

    MAX_CAR_NAME_LENGTH(5);

    private final int value;

    Constant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
