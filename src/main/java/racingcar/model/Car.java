package racingcar.model;

import racingcar.enums.Constants;

public class Car {
    Name carName;
    Distance carDistance;

    public Car(Name carName, Distance carDistance) {
        this.carName = carName;
        this.carDistance = carDistance;
    }

    public void move(Integer randomNumber) {
        if (determineMove(randomNumber)) moveForward();
    }

    public Name getCarName() {
        return carName;
    }

    public Distance getCarDistance() {
        return carDistance;
    }

    private boolean determineMove(Integer number) {
        if (number >= Constants.MOVE_NUMBER.getNumber()) {
            return true;
        }
        return false;
    }

    private void moveForward() {
        this.carDistance.updateDistance(carDistance.getDistance() + Constants.FORWARD.getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!carName.equals(car.carName)) return false;
        return carDistance.equals(car.carDistance);
    }

    @Override
    public int hashCode() {
        int result = carName != null ? carName.hashCode() : 0;
        result = 31 * result + (carDistance != null ? carDistance.hashCode() : 0);
        return result;
    }
}
