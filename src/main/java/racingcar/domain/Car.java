package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final String POSITION_REGEX = "-";
    private static final int MOVABLE_THRESHOLD = 3;

    private int position;
    private final Name name;

    private Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    public void move(int randomNumber) {
        if (isMovable(randomNumber)) {
            this.position++;
        }
    }
    public Name getName() {
        return name;
    }

    public boolean isSamePosition(Car otherCar) {
        return this.position == otherCar.position;
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber > MOVABLE_THRESHOLD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, POSITION_REGEX.repeat(Math.max(0, position)));
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position - otherCar.position;
    }

}
