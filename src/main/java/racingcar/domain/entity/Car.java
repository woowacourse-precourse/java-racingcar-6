package racingcar.domain.entity;

import racingcar.domain.entity.valueobject.CarLocation;
import racingcar.domain.entity.valueobject.CarName;

public class Car {
    private CarName name;
    private CarLocation location;

    public Car(String name) {
        this.name = new CarName(name);
        this.location = new CarLocation();
    }

    public String getName() {
        return name.getName();
    }

    public CarLocation getLocation() {
        return location;
    }

    public void forward() {
        location.forward();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Car otherCar = (Car) other;
        return name.equals(otherCar.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
