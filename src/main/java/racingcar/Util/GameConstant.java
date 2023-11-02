package racingcar.Util;

public enum GameConstant {
    EMPTY_INPUT_SIZE(0),
    CAR_NAME_MAX_LENGTH(5),
    CAR_NAME_MIN_LENGTH(1),
    MOVEMENT_COUNT_MIN(1),
    MAX_DISPLACEMENT_INIT(0),
    MIN_PLAY_ROUND(1);

    private final int value;

    GameConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
