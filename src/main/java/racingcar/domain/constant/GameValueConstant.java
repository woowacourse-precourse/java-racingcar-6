package racingcar.domain.constant;

public enum GameValueConstant {
    CAR_NAME_MAX_LENGTH(5),
    CAR_INIT_DISTANCE(0),
    MINIMUM_PARTICIPANT_CARS(2),
    RANDOM_VALUE_LOWER_LIMIT(0),
    RANDOM_VALUE_UPPER_LIMIT(9),
    MOVE_OR_STOP_BOUNDARY(4);

    private final int value;

    GameValueConstant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}