package racingcar.domain;

import java.util.Objects;

public class Car {

    private final CarName name;
    private final CarPosition position;

    public Car(CarName name) {
        this.name = name;
        this.position = new CarPosition();
    }

    @Override
    public boolean equals(Object obj) {
        Car car = (Car) obj;
        CarName carName = car.name;
        CarPosition carPosition = car.position;
        boolean isNameEquals = name.equals(carName);
        boolean isPositionEquals = position.equals(carPosition);
        return isNameEquals && isPositionEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}
