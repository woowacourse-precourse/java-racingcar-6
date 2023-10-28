package racingcar.model;

import racingcar.utils.Validator;

public class Car {
    private String carName;
    private int forwardSteps;

    private final static Validator validator = new Validator();

    public Car(String carName) {
        validator.checkCarName(carName);
        this.carName = carName;
        this.forwardSteps = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardSteps() {
        return forwardSteps;
    }

    public void setForwardSteps(int forwardSteps) {
        this.forwardSteps = forwardSteps;
    }

    @Override
    public String toString() {
        return "Car(" + carName + ',' + forwardSteps + ')';
    }
}
