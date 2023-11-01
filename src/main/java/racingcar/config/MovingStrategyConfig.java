package racingcar.config;

public enum MovingStrategyConfig {
    MOVABLE_NUMBER(4),
    RANGE_START_NUMBER(0),
    RANGE_END_NUMBER(9);

    private final int setting;

    MovingStrategyConfig(final int setting) {
        this.setting = setting;
    }

    public int getSetting() {
        return setting;
    }
}
