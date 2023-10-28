package racingcar.configuration;

public enum GameConfiguration {
    // Constraint
    FORWARD_CONDITION(4),

    RANDOM_MINIMUM_CONSTRAINT(0),
    RANDOM_MAXIMUM_CONSTRAINT(9),
    ;

    private final int value;

    GameConfiguration(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
