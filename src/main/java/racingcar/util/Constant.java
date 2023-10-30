package racingcar.util;

public enum Constant {

    ZERO(0),
    START_INCLUSIVE(0),
    ONE_INDEX(1),
    NEXT_INDEX(1),
    FORWARD_THRESHOLD(4),
    MAX_CAR_NAME_LENGTH(5),
    END_INCLUSIVE(9);

    private final int value;

    Constant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
