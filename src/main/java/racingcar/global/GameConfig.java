package racingcar.global;

public enum GameConfig {
    // Constraint
    NAME_MAXIMUM_CONSTRAINT(5),
    FORWARD_CONDITION(4),
    RANDOM_MINIMUM_CONSTRAINT(0),
    RANDOM_MAXIMUM_CONSTRAINT(9),
    ;

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
