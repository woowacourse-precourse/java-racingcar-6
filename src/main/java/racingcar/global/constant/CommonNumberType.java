package racingcar.global.constant;

public enum CommonNumberType {

    MINIMUM_FORWARD(4),
    MAXIMUM_LENGTH_OF_NAME(5);

    private final int value;

    CommonNumberType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
