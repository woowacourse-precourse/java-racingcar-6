package racingcar.constants;

public enum Integers {
    RANDOM_NUMBER_MIN(0),
    RANDOM_NUMBER_MAX(9),
    MIN_FORWARD_CONDITION(4),
    MAX_CAR_NAME_LENGTH(5);


    private final int value;

    Integers(int value) {
        this.value = value;
    }

    public int show() {
        return value;
    }


}
