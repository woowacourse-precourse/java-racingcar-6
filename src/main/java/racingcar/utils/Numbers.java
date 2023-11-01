package racingcar.utils;

public enum Numbers {

    RANDOM_START_NUMBER(0),
    RANDOM_END_NUMBER(9),
    MOVE_POSITION_NUMBER(4),
    STAY_POSITION_NUMBER(3),
    ALONE_NUMBER(1);

    private final int number;

    Numbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
