package racingcar;

public enum GameConfig {
    MAX_CAR_COUNT(9),
    MIN_CAR_COUNT(2),
    MAX_CAR_NAME(5),
    MIN_CAR_NAME(1),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    MIN_MOVE_VALUE(4),
    MIN_ROUND_COUNT(1),
    INIT_NUMBER(0);

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
