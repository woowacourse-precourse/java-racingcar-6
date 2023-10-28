package racingcar;

public class Position {

    private static final Position ZERO = new Position(0);
    private int position;

    public Position(Position position) {
        this.position = position.position;
    }

    public Position(int position) {
        this.position = position;
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
