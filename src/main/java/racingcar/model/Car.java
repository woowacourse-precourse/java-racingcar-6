package racingcar.model;

import java.util.Objects;

public final class Car {
    private final CarName name;
    private final CarPosition position;

    Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String carName) {
        CarName name = CarName.from(carName);
        CarPosition defaultPosition = CarPosition.initialPosition();
        return new Car(name, defaultPosition);
    }

    public Car move(MovementCondition movementCondition) {
        if (movementCondition.isMovable()) {
            CarPosition movedPosition = position.move();
            return new Car(name, movedPosition);
        }
        return new Car(name, position);
    }

    public boolean isSamePosition(CarPosition maxPosition) {
        return position.equals(maxPosition);
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getPosition() {
        return position;
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
}
