package racingcar.constant;

public enum GameConfig {

    MINIMUM_NUMBER_FOR_FORWARD(4),
    MAXIMUM_CAR_NAME_LENGTH(5),
    RANDOM_MINIMUM_RANGE(0),
    RANDOM_MAXIMUM_RANGE(9);

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
