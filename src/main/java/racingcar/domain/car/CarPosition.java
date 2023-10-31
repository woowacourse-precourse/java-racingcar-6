package racingcar.domain.car;

import java.util.Objects;

public class CarPosition implements Comparable<CarPosition> {
    private static final int START_POSITION = 0;

    private int position;

    private CarPosition(int position) {
        this.position = position;
    }

    public static CarPosition createStartPosition() {
        return new CarPosition(START_POSITION);
    }

    public static CarPosition create(CarPosition carPosition) {
        return new CarPosition(carPosition.position);
    }

    public void move(int distance) {
        position += distance;
    }

    @Override
    public int compareTo(CarPosition carPosition) {
        return Integer.compare(position, carPosition.position);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CarPosition carPosition)) {
            return false;
        }

        return position == carPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return position;
    }
}
