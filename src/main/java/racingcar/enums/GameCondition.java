package racingcar.enums;

public enum GameCondition {
    MIN_CARS(2),
    MAX_CAR_NAME_SIZE(5),
    MIN_COUNT(1),
    START_POSITION(0),
    CAR_SPEED(1),
    RANDOM_NUMBER_START_INCLUSIVE(0),
    RANDOM_NUMBER_END_INCLUSIVE(9);

    private final int value;

    GameCondition(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
