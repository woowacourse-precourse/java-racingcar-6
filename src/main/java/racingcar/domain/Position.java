package racingcar.domain;

public class Position {
    private final static int MOVING_FORWARD_CRITERION = 4;
    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position move() {
        return new Position(this.position + 1);
    }

    public boolean isMovable(int number) {
        return number >= MOVING_FORWARD_CRITERION;
    }

    public int getPosition() {
        return position;
    }
}
