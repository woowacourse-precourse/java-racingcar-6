package racingcar.domain.car;

import racingcar.domain.valueobject.CarLocation;
import racingcar.domain.valueobject.CarName;

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
}
