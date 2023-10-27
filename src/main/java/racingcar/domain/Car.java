package racingcar.domain;

public class Car {
    private final MovingStrategy movingStrategy;

    private final String name;
    private int position;

    public Car(MovingStrategy movingStrategy, String name, int position) {
        validateNameLength(name);
        validateInitPosition(position);
        this.movingStrategy = movingStrategy;
        this.name = name;
        this.position = position;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInitPosition(int position) {
        if (position != 0) {
            throw new IllegalArgumentException();
        }
    }
}
