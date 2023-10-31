package racingcar.model;

public enum CarNameLength {
    MINIMUM(1),
    MAXIMUM(5);

    private final int value;

    CarNameLength(final int value) {
        this.value = value;
    }

    public final int getValue() {
        return value;
    }
}

