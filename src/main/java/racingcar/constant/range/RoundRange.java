package racingcar.constant.range;

public enum RoundRange {
    MIN(1),
    MAX(10000);

    private final int value;

    RoundRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
