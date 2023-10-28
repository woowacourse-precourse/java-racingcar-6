package racingcar.domain;

import java.util.Objects;

public class CarPosition {
    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public boolean isGreaterThan(final CarPosition other) {
        return this.position > other.position;
    }

    public String getPositionAsString() {
        StringBuilder positionString = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionString.append("-");
        }
        return positionString.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
