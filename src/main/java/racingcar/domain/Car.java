package racingcar.domain;

import racingcar.service.BasicMovementRule;

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

    public void move(BasicMovementRule basicMovementRule, int randomNumber) {
        if (basicMovementRule.isMovingCondition(randomNumber)) {
            position.increase();
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
