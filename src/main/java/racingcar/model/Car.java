package racingcar.model;

import java.util.Objects;

public class Car {

    private static final int MINIMUM_RACE_VALUE = 4;

    private final Name name;
    private final Position position;

    private Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car createDefault(final Name name) {
        Position defaultPosition = Position.createDefault();
        return new Car(name, defaultPosition);
    }

    public void move(final int number) {
        if (isNumberSatisfiedToMove(number)) {
            position.increase();
        }
    }

    private static boolean isNumberSatisfiedToMove(final int number) {
        return number >= MINIMUM_RACE_VALUE;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Car car = (Car) other;
        return Objects.equals(name.getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.getName());
    }
}
