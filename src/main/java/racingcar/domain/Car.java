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

    public void move(final MovingStrategy strategy) {
        if (strategy.canMove()) {
            carPosition.move();
        }
    }

    public boolean isSamePosition(final int carPosition) {
        return this.carPosition.equals(CarPosition.from(carPosition));
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return carPosition.getPosition();
    }

    @Override
    public String toString() {
        return carName.getName() + " : " + "-".repeat(carPosition.getPosition());
    }
}
