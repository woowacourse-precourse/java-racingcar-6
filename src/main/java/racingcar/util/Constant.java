package racingcar.util;

public enum Constant {

    ZERO(0),
    NEXT_INDEX(1),
    FORWARD_THRESHOLD(4),
    MAX_CAR_NAME_LENGTH(5);


    private final int value;

    Constant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
