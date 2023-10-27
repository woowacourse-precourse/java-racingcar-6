package racingcar.constant;

public enum CarName {
    MIN_LENGTH(1),
    MAX_LENGTH(5);

    private final int value;

    CarName(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
