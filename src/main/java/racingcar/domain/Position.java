package racingcar.domain;

public class Position {
    private static final int INIT_POSITION = 0;
    private static final int MOVING_INTERVAL = 1;

    private final int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position init() {
        return new Position(INIT_POSITION);
    }

    public Position moveForward() {
        return new Position(this.value + MOVING_INTERVAL);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final Position other = (Position) object;
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
