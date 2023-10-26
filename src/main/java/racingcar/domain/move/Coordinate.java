package racingcar.domain.move;

import java.util.Objects;

public class Coordinate {
    private static final int MIN_COORDINATE = 0;
    private int coordinate;

    public Coordinate(final int coordinate) {
        validateCoordinate(coordinate);
        this.coordinate = coordinate;
    }

    public static Coordinate zero() {
        return new Coordinate(MIN_COORDINATE);
    }

    public static void validateCoordinate(final int coordinate) {
        if (coordinate < MIN_COORDINATE) {
            throw new InvalidCoordinateException();
        }
    }

    public void increase() {
        coordinate++;
    }

    public int getCoordinate() {
        return coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) o;
        return coordinate == that.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
