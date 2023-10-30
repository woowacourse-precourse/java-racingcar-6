package racingcar.domain;

public class Car {
    private final CarName carName;
    private final CarPosition carPosition;

    public Car(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public CarName getName() {
        return carName;
    }

    public CarPosition getPosition() {
        return carPosition;
    }

    public Car move(int number) {
        if (number > 4) {
            return new Car(this.carName, this.carPosition.next());
        }
        return this;
    }
}
