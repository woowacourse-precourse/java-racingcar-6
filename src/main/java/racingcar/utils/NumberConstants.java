package racingcar.utils;

public enum NumberConstants {
    MINIMUM_CAR_NAME_LENGTH(1),
    MAXIMUM_CAR_NAME_LENGTH(5),
    MINIMUM_ROUNDS(1),
    MAXIMUM_ROUNDS(100),
    MINIMUM_RANDOM_NUMBER(1),
    MAXIMUM_RANDOM_NUMBER(100);

    private int value;

    NumberConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
