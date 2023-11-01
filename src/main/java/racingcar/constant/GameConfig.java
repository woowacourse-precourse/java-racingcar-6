package racingcar.constant;

public enum GameConfig {
    MAX_CAR_NAME_LENGTH(5),
    RANDOM_NUMBER_MINIMUM(1),
    RANDOM_NUMBER_MAXIMUM(9),
    ;

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
