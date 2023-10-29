package racingcar.model;

import java.util.Objects;

public class Position {
    private static final int ZERO_POSITION = 0;
    private static final int MOVE_SIZE = 1;
    private static final String DISPLAY_STRING = "-";
    private int position;

    public Position() {
        position = ZERO_POSITION;
    }

    public void movePosition() {
        this.position += MOVE_SIZE;
    }
    
    public String getDisplayFormat() {
        return DISPLAY_STRING.repeat(position);
    }

    public boolean isGreaterThan(Position other) {
        return this.position > other.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position that = (Position) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
