package racingcar.domain;

import racingcar.service.Rule;

public class Car {

    private static final int INITIAL_POSITION = 0;

    private final String carName;
    private final Position position;

    public Car(final String carName) {
        this.carName = carName;
        this.position = new Position(INITIAL_POSITION);
    }

    public String getCarName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }

    public void move(Rule rule, int randomNumber) {
        if (rule.isMovingCondition(randomNumber)) {
            position.increasePosition();
        }
    }

    public int getCarPosition() {
        return position.getCarPosition();
    }

    @Override
    public String toString() {
        return carName;
    }
}
