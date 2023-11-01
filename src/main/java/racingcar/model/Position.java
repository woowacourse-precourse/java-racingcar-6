package racingcar.model;

public class Position {

    private static final int MIN_POSITION_VALUE = 0;
    private static final int MOVE_FORWARD_STEP = 1;
    private static final int INITIAL_STEP = 0;

    private int position;

    public Position(final int position) {
        validate(position);
        this.position = position;
    }

    private void validate(final int position) {
        if (position < MIN_POSITION_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    public static Position withZero() {
        return new Position(INITIAL_STEP);
    }

    public void moveForward() {
        this.position += MOVE_FORWARD_STEP;
    }

    public int getPosition() {
        return position;
    }
}
