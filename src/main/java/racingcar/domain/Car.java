package racingcar.domain;

import static racingcar.domain.DomainConstant.CAR_MOVE_CONDITION;

public class Car {
    private int position;
    private final String carName;


    public Car(String carName) {
        this.carName = carName;
        position = 0;
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
