package racingcar.common;

public enum Rule {
    MAX_CAR_NAME_LENGTH(5),
    MOVING_FORWARD(4)
    ;

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
