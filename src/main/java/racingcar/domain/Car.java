package racingcar.domain;

import static racingcar.domain.constant.DomainConstant.CAR_INIT_POSITION;
import static racingcar.domain.constant.DomainConstant.CAR_MOVE_CONDITION;

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
}
