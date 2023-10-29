package racingcar.model;

import java.util.Objects;

public class Car {

    private static final int MINIMUM_ACCERATE_VALUE = 4;
    private static final String POSITION_MARK = "-";

    private final Name name;
    private int position;

    private Car(final Name name) {
        this.name = name;
        this.position = 0;
    }

    public static Car from(final Name name) {
        return new Car(name);
    }

    public void accelerate(final int number) {
        if (number >= MINIMUM_ACCERATE_VALUE) {
            position++;
        }
    }

    public boolean isWinner(final int gameCount) {
        return gameCount == position;
    }

    public boolean isPositionEqualTo(final int number) {
        return position == number;
    }

    @Override
    public String toString() {
        return name.getName() + " : " + POSITION_MARK.repeat(position);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if ((other == null) || (getClass() != other.getClass())) {
            return false;
        }
        Car car = (Car) other;
        return Objects.equals(name.getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.getName());
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
