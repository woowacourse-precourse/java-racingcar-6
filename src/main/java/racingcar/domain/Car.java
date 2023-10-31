package racingcar.domain;

public class Car {

    private CarName carName;

    public Car(final String name) {
        this.carName = new CarName(name);
    }
}