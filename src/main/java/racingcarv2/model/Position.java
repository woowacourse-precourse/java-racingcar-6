package racingcarv2.model;

import java.util.Objects;

public class Position {
    private int positionValue;

    public Position(int position) {
        this.positionValue = position;
    }

    public void increase() {
        this.positionValue++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return getPositionValue() == position1.getPositionValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPositionValue());
    }

    public int getPositionValue() {
        return positionValue;
    }
}
