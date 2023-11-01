package racingcar.car;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private final Position position;

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public void move(MoveNumber number) {
        if (isMovable(number)) {
            position.move();
        }
    }

    private static boolean isMovable(MoveNumber number) {
        return number.isMovable();
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
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName=" + carName +
                ", position=" + position +
                '}';
    }
}
