package racingcar.model;

import static racingcar.common.Config.*;

public class Car {
    private final String carName;
    private Integer countingMovement;

    public Car(String carName) {
        this.carName = carName;
        this.countingMovement = 0;
    }

    public Integer getCountingMovement() {
        return countingMovement;
    }

    public String getCarName() {
        return this.carName;
    }

    public void forwardCar() {
        this.countingMovement++;
    }

    @Override
    public String toString() {
        return this.carName + " : " + this.countingMovementToString() + "\n";
    }

    private String countingMovementToString() {
        return RACING_COUNT_CHARACTER.repeat(
                Math.max(0, countingMovement));
    }
}
