package racingcar.domain;

public enum GameCondition {
    NAME_SIZE(5),
    MOVING_FORWARD(4),
    MIN_RANDOM_NUM(0),
    MAX_RANDOM_NUM(9);


    private final int value;

    GameCondition(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
