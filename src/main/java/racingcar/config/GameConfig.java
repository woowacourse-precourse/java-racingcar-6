package racingcar.config;

public enum GameConfig {
    FORWARD_CONDITION(4),
    START_OF_RANGE(0),
    END_OF_RANGE(9),
    MAX_TRY_COUNT(Integer.MAX_VALUE),
    MAX_CAR_NAME_LENGTH(5);

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
