package racingcar.domain.car;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private int position;
    private final Name name;

    public Car(final String name) {
        this.name = new Name(name);
    }

    public void moveForward() {
        position += 1;
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
        return name.getName().equals(car.name.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.getName());
    }

    @Override
    public int compareTo(Car car) {
        return car.position - this.position;
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

}
