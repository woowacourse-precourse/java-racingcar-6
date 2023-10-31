package racingcar.domain;

public class Position {
    private static final int INITIAL_DISTANCE = 0;
    private static final String INITIAL_POSITION = "%s : ";
    private int distance;
    private StringBuilder position;

    private Position(Car car) {
        this.distance = INITIAL_DISTANCE;
        this.position = new StringBuilder(String.format(INITIAL_POSITION, car.carInfo()));
    }

    public static Position createPosition(Car car) {
        return new Position(car);
    }

    public int distanceValue() {
        return this.distance;
    }

    public String positionValue() {
        return this.position.toString();
    }

    public void move(int distance) {
        this.distance += distance;
        this.position.append("-".repeat(distance));
    }
}
