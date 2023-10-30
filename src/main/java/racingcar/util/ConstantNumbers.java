package racingcar.util;

public enum ConstantNumbers {
    MINIMUM_TRY_COUNT(0),
    STARTING_INDEX(1),
    LOWER_BOUND(0),
    UPPER_BOUND(9),
    THRESHOLD(4),
    MAXIMUM_NAME_LENGTH(5);

    private final int number;

    ConstantNumbers(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }
}
