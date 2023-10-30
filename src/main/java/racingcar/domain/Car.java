package racingcar.domain;

public class Car {
    private final CarName carName;
    private final CarPosition carPosition;

    public Car(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return carPosition.getPosition();
    }

    public Car move(int number) {
        if (number > 4) {
            return new Car(this.carName, this.carPosition.next());
        }
        return this;
    }

    public boolean isSamePosition(Car highestCar) {
        return carPosition.equals(highestCar.carPosition);
    }
}
