package racingcar.config;

public enum CarNameLength {
    MAX_LENGTH(5);

    private final int value;

    CarNameLength(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}