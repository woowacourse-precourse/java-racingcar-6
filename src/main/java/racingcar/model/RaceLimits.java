package racingcar.model;

public enum RaceLimits {
    REFERENCE_NUMBER(4),
    MAXIMUM(100),
    MINIMUM(1),
    FINISH(0);

    private final int value;

    RaceLimits(final int value) {
        this.value = value;
    }

    public final int getValue() {
        return this.value;
    }
}
