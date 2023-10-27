package racingcar.constant;

public enum CarPosition {
    INITIAL_POSITION(0);

    private final int value;

    CarPosition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
