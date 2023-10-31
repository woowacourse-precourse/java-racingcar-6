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

    private boolean determineMove(Integer number) {
        if (number >= Constants.MOVE_NUMBER.getNumber()) {
            return true;
        }
        return false;
    }

    private void moveForward() {
        this.carDistance.setDistance(carDistance.getDistance() + Constants.FORWARD.getNumber());
    }
}
