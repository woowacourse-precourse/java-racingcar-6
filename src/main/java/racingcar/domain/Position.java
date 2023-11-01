package racingcar.domain;

public class Position {

    protected static final int INITIAL_POSITION = 0;

    private int value;

    public Position() {
        this.value = INITIAL_POSITION;
    }

    public void increase() {
        this.value++;
    }

    public int getValue() {
        return value;
    }
}
