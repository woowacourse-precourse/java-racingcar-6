package racingcar.constant;

public enum GameConstant {

    RANDOM_MIN_NUM(0),
    RANDOM_MAX_NUM(9),
    SCORE_BOUND(4);

    private int value;

    GameConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
    }