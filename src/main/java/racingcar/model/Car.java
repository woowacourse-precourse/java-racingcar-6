package racingcar.model;

import racingcar.model.vo.CarName;

public class Car {

    private CarName name;
    private Location location;

    public Car(CarName carName) {
        this.name = carName;
        this.location = new Location();
    }

    public String playGameOneRound() {
        location.stopOrMove();
        return toResult();
    }

    private String toResult() {
        return name.toString() + " : " + location.toString();
    }

    public Integer getCarLocationLength() {
        return location.getLocationLength();
    }

    public String getCarName() {
        return name.getName();
    }
}
