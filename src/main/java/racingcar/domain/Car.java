package racingcar.domain;

public class Car {
    private final CarName carName;
    private final CarPosition carPosition;

    private Car(final CarName carName, final CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static Car zeroPositionFrom(final String name) {
        return new Car(CarName.from(name), CarPosition.zeroPosition());
    }
}
