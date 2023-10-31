package racingcar.domain;

import static racingcar.domain.constant.CarConstant.CAR_MOVE_CONDITION;
import static racingcar.domain.constant.CarConstant.DISTANCE;

import java.util.Objects;

public class Car {
    private final Position position;
    private final String name;

    public Car(String name) {
        this.name = name;
        position = new Position();
    }

    public int move(int moveDecisionNumber) {
        if (moveDecisionNumber >= CAR_MOVE_CONDITION) {
            position.moveForward(DISTANCE);
        }

        return position.toInt();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.toInt();
    }

    public boolean isSamePosition(int position) {
        return this.getPosition() == position;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object comparedCar) {
        if (this == comparedCar) {
            return true;
        }

        if (comparedCar == null || getClass() != comparedCar.getClass()) {
            return false;
        }

        Car cars = (Car) comparedCar;
        return Objects.equals(name, cars.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
