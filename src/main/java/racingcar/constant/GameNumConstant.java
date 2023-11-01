package racingcar.constant;

public enum GameNumConstant {

    RANDOM_MIN_NUM(0),
    RANDOM_MAX_NUM(9),
    SCORE_BOUND(4);

    private final int value;

    GameNumConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}