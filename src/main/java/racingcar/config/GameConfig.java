package racingcar.config;

public enum GameConfig {

    MOVEMENT_CONDITION_NUMBER(4),
    MOVEMENT_DISTANCE(1),
    RANDOM_NUMBER_RANGE_START(0),
    RANDOM_NUMBER_RANGE_END(9),
    NAME_LENGTH_CONDITION(5);


    private final int number;

    GameConfig(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
