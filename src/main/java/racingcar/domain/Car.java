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

    public int stopOrMoveDecision(int randomNumber) {
        if (randomNumber >= CAR_MOVE_CONDITION) {
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

    @Override
    public String toString() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Car car)) {
            return false;
        }

        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

}
