package racingcar.util.constant;

public enum GameRule {

    MAX_NICKNAME_LENGTH(4),
    START_INCLUSIVE(0),
    END_INCLUSIVE(9),
    MOVING_FORWARD_CONDITION(4);

    private final Integer value;

    GameRule(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
