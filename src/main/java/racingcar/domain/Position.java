package racingcar.domain;

public class Position {

    private static final int START_POSITION = 0;

    private int value;

    public static Position setStartPosition() {
        return new Position();
    }

    private Position() {
        this.value = START_POSITION;
    }

    public void move() {
        this.value++;
    }

    public int getValue() {
        return value;
    }
}
