package Config;

public enum RaceConfig {
    MOVE_CRITERIA(4),
    MOVE_START_RANGE(0),
    MOVE_END_RANGE(9);
    private final int value;
    RaceConfig(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
