package racingcar.constants;

public enum RaceRule {
    MOVE_MIN_RANGE(0),
    MOVE_MAX_RANGE(9),
    MOVE_THRESHOLD(4);

    private final int value;

    RaceRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
