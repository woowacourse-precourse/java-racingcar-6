package racingcar;

public enum Constant {

    RANDOM_MINIMUM_NUMBER(0),
    RANDOM_MAXIMUM_NUMBER(9);

    private final int value;

    Constant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
