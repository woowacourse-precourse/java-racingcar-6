package racingcar.model;

public enum CarNameLength {
    MINIMUM(1),
    MAXIMUM(5);

    private final int value;

    CarNameLength(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
