package racingcarv2.model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    public static final int MOVE_FORWARD_CRITERIA = 4;
    private final Name name;
    private final Position position;

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_CRITERIA) {
            moveForward();
        }
    }

    public boolean isSamePosition(Car otherCar) {
        return Objects.equals(this.position, otherCar.position);
    }

    private void moveForward() {
        position.increase();
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
        return Objects.equals(getName(), car.getName()) && Objects.equals(getPosition(),
                car.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position.getPositionValue() - otherCar.position.getPositionValue();
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
