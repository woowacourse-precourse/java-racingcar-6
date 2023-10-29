package racingcar.enums;

public enum Integers {
    RANDOM_NUMBER_MIN(0),
    RANDOM_NUMBER_MAX(9),
    MIN_FORWARD_CONDITION(4);

    private final int value;

    Integers(int value) {
        this.value = value;
    }

    public int show() {
        return value;
    }


}
