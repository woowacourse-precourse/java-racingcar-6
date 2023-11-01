package racingcar.domain;

import racingcar.service.BasicMovementRule;

public class Car {

    private final String carName;
    private final Position position;

    public Car(final String carName) {
        this.carName = carName;
        this.position = new Position(IntegerConstant.INITIAL_POSITION.getValue());
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
