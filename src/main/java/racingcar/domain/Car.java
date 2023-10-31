package racingcar.domain;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private Position position;

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public void move(Strategy strategy) {
        if (strategy.movable()) {
            this.position = position.move();
        }
    }

    public String getCarName() {
        return carName.getName();
    }

    public Position getPosition() {
        return position;
    }

    public int getDistance() {
        return position.getDistance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
