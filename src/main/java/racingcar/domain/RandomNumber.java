package racingcar.domain;

public enum RandomNumber {
    MIN(0),
    MAX(9),
    THRESHOLD(4);

    private final int value;

    RandomNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
