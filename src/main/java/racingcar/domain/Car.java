package racingcar.domain;

import racingcar.domain.dto.CarResult;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String carName) {
        this.name = new Name(carName);
        this.position = new Position();
    }

    public CarResult move(int randomNumber) {
        this.position.move(randomNumber);
        return CarResult.of(this.name, this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
