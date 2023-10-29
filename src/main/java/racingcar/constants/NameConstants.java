package racingcar.constants;

public enum NameConstants {
    LOW_BOUND(1),
    HIGH_BOUND(5);

    private final int value;

    NameConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
