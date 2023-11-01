package racingcar.domain;

public class Position {

    private static final int INITIAL_POSITION_SIZE = 0;
    private int position;

    private Position() {
        this.position = INITIAL_POSITION_SIZE;
    }

    public static Position initial() {
        return new Position();
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
