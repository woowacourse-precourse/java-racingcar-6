package racingcar.domain;

import static racingcar.domain.constant.CarConstant.CAR_INIT_POSITION;
import static racingcar.domain.constant.CarConstant.CAR_MOVE_CONDITION;

import java.util.Objects;

public class Car {
    private int position;
    private final String carName;

    public Car(String carName) {
        this.carName = carName;
        position = CAR_INIT_POSITION;
    }

    public int decisionMoveOrStop(int moveDecisionNumber) {
        if (moveDecisionNumber >= CAR_MOVE_CONDITION) {
            position++;
        }

        return position;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.getCarPosition() == position;
    }

    @Override
    public String toString() {
        return carName;
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
        return Objects.equals(carName, cars.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

}
