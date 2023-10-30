package racingcar.model.constants;

public enum Rule {
    CAR_MIN_LENGTH(1),
    CAR_MAX_LENGTH(5),

    TRIAL_MIN_LENGTH(1),

    RANDOM_MIN_SIZE(0),
    RANDOM_MAX_SIZE(9),

    MOVE_VALUE(4);

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}