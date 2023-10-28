package racingcar.config;

public enum GameConfig {
    FORWARD_CONDITION(4),
    START_OF_RANGE(0),
    END_OF_RANGE(9),
    MAX_TRY_COUNT(Integer.MAX_VALUE),
    MAX_CAR_NAME_LENGTH(5),
    SPLIT_REGEX(",");

    private final Integer intValue;
    private final String stringValue;

    GameConfig(Integer intValue) {
        this.intValue = intValue;
        this.stringValue = null;
    }

    GameConfig(String stringValue) {
        this.intValue = null;
        this.stringValue = stringValue;
    }

    GameConfig(String stringValue, Integer intValue) {
        this.stringValue = stringValue;
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
