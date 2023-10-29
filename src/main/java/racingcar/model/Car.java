package racingcar.model;

import racingcar.validation.CarValidator;

public class Car {

    private final String carName;
    private Integer movingDistance;

    private static final int STARTING_LINE = 0;
    private static final int MOVE_CONDITION_MIN_NUMBER = 4;
    private static final int MOVE_ONE_STEP = 1;

    public Car(String carName) {
        CarValidator.validateCarName(carName);
        this.carName = carName;
        this.movingDistance = STARTING_LINE;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION_MIN_NUMBER) {
            this.movingDistance += MOVE_ONE_STEP;
        }
    }
}
