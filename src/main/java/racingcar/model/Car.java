package racingcar.model;

import racingcar.model.vo.CarName;

public class Car {

    private CarName name;
    private Location location;

    public Car(CarName carName) {
        this.name = carName;
        this.location = new Location();
    }

    public Location playGameOneRound() {
        location.stopOrMove();
        return this.location;
    }

    public Integer getCarLocationLength() {
        return location.getLocationLength();
    }

    public CarName getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.toString() + " : " + location.toString();
    }
}
