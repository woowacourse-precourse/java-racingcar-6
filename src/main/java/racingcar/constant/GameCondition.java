package racingcar.constant;

public enum GameCondition {
    NAME_MAX_SIZE(5),
    MOVING_FORWARD_CONDITION(4),    //전진조건
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
