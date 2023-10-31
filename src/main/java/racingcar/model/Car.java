package racingcar.model;

import racingcar.model.vo.CarName;

public class Car {

    private CarName name;
    private Location location;

    public Car(CarName carName) {
        this.name = carName;
        this.location = new Location();
    }

    public static Car make(CarName carName) {
        return new Car(carName);
    }

    public void playGameOneRound() {
        location.stopOrMove();
    }

    @Override
    public String toString() {
        return name.toString() + " : " + location.toString();
    }
}
