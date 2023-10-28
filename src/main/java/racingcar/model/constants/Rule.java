package racingcar.model.constants;

public enum Rule {
    CAR_MIN_LENGTH(1),
    CAR_MAX_LENGTH(5);

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
