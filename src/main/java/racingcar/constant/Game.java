package racingcar.constant;

public enum Game {
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    MIN_NAME_LENGTH(1),
    MAX_NAME_LENGTH(5),
    MOVE_CONDITION(4);

    private final int num;

    Game(int num) {
        this.num = num;
    }

    public int is() {
        return num;
    }
}
