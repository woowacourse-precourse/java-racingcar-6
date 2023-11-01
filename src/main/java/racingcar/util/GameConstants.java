package racingcar.util;

public enum GameConstants {
    CAR_INITIAL_POSITION(0),
    MOVE_FORWARD_THRESHOLD(4),
    LAST_ROUND(0),
    MAX_CAR_NAME_LENGTH(5),
    MIN_ROUND(1),
    MIN_NUMBER(0),
    MAX_NUMBER(9);

    private final int value;

    GameConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
