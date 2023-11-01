package racingcar.domain;

public class Car {

    private CarName carName;
    private Distance distance;

    public Car(final String name, final int distance) {
        this.carName = new CarName(name);
        this.distance = new Distance(distance);
    }

    }

    public CarName getCarName() {
        return carName;
    }
}