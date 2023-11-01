package racingcar.domain;

public class Car {
    private final CarName carName;

    private Car(final CarName carName) {
        this.carName = carName;
    }

    public static Car of(final CarName carName) {
        return new Car(carName);
    }
}
