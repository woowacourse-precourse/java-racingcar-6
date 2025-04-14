package racingcar.commponent;

public enum GameCondition {
    MOVING_FORWARD(4), STOP(3);

    private final int value;

    GameCondition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
