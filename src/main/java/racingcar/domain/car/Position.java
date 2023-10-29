package racingcar.domain.car;

public class Position {

    public static final int START_POSITION = 0;

    private int value;

    public static Position setStartPosition() {
        return new Position();
    }

    private Position() {
        this.value = START_POSITION;
    }

    public void move(int distance) {
        this.value += distance;
    }

    public int getValue() {
        return value;
    }
}
