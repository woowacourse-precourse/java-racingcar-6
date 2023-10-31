package racingcar.domain;

public class Car {
    private static final int LEAST_NUMBER = 4;

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
        if (isGreaterThanLeastNumber(number)) {
            return new Car(this.carName, this.carPosition.next());
        }
        return this;
    }

    private boolean isGreaterThanLeastNumber(int number) {
        return number >= LEAST_NUMBER;
    }

    public boolean isSamePosition(Car highestCar) {
        return carPosition.equals(highestCar.carPosition);
    }
}
