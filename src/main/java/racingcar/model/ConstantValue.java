package racingcar.model;

public enum ConstantValue {
    MIN_NUM_OF_CAR(2),
    MAX_LEN_OF_CAR_NAME(5),
    MIN_NUM_OF_MATCHES(1);

    private final int value;

    ConstantValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
