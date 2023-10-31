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
        if (isGreaterThanOrEqualToLeastNumber(number)) {
            return new Car(this.carName, this.carPosition.goForward());
        }
        return this;
    }

    private boolean isGreaterThanOrEqualToLeastNumber(int number) {
        return number >= LEAST_NUMBER;
    }

    public boolean isSamePosition(Car farthestCar) {
        return carPosition.equals(farthestCar.carPosition);
    }

}
