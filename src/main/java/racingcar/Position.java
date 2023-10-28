package racingcar;

public class Position {

    private static final Position ZERO = new Position(0);
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public static Position zero() {
        return ZERO;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public int getPosition() {
        return position;
    }
}
