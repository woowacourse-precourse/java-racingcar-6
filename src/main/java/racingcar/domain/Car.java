package racingcar.domain;

import racingcar.service.BasicMovementRule;

public class Car implements Comparable<Car> {

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

    public int getCarPosition() {
        return position.getCarPosition();
    }

    public void move(BasicMovementRule basicMovementRule, int randomNumber) {
        if (basicMovementRule.isMovingCondition(randomNumber)) {
            position.increase();
        }
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position.getCarPosition() - otherCar.position.getCarPosition();
    }

    @Override
    public String toString() {
        return carName;
    }
}
