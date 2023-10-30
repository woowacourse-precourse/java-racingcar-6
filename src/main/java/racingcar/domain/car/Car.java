package racingcar.domain.car;

import racingcar.domain.car.valueobject.CarLocation;
import racingcar.domain.car.valueobject.CarName;

public class Car {
    private CarName name;
    private CarLocation location;

    public Car(String name) {
        this.name = new CarName(name);
        this.location = new CarLocation();
    }

    public CarName getName() {
        return name;
    }

    public CarLocation getLocation() {
        return location;
    }

    public void forward() {
        location.forward();
    }
}
