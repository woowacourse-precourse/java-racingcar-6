package racingcar.domain;

import static racingcar.domain.constant.CarConstant.CAR_INIT_POSITION;
import static racingcar.domain.constant.CarConstant.CAR_MOVE_CONDITION;

import java.util.Objects;

public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        this.name = name;
        position = CAR_INIT_POSITION;
    }

    public int move(int moveDecisionNumber) {
        if (moveDecisionNumber >= CAR_MOVE_CONDITION) {
            position++;
        }

        return position;
    }

    public String getCarName() {
        return name;
    }

    public int getCarPosition() {
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.getCarPosition() == position;
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
