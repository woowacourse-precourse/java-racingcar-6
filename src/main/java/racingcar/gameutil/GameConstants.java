package racingcar.gameutil;

public enum GameConstants {

    RANDOM_NUMBER_MIN_RANGE(0),
    RANDOM_NUMBER_MAX_RANGE(9),
    MOVE_DISTANCE(1),
    CAN_MOVE_MIN_VALUE(4);

    private final int value;

    GameConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
