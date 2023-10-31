package racingcar;

public enum GameConfig {
    MAX_CAR_COUNT(9),
    MIN_CAR_COUNT(2),
    MAX_CAR_NAME(5),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    MIN_MOVE_VALUE(4);

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
