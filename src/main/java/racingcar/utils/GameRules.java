package racingcar.utils;

public enum GameRules {
    START_RANGE(0),
    END_RANGE(9),
    START_POSITION(0),
    GO_CONDITION(4),
    NAME_LIMIT(5);

    private final int value;

    GameRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
