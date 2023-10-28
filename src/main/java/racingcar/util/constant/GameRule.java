package racingcar.util.constant;

public enum GameRule {
    MAX_NICKNAME_LENGTH(4);

    private final Integer value;

    GameRule(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
