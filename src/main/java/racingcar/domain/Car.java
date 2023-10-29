package racingcar.domain;

import java.util.Objects;

public class Car {
    private final String name;
    private Position position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position = position.move();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
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
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
