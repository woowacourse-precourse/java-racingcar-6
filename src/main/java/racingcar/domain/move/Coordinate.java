package racingcar.domain.move;

public record Coordinate(int coordinate) {

    private static final int MIN_COORDINATE = 0;

    public Coordinate {
        validateCoordinate(coordinate);
    }

    public static void validateCoordinate(final int coordinate) {
        if (coordinate < MIN_COORDINATE) {
            throw new InvalidCoordinateException();
        }
    }
}
