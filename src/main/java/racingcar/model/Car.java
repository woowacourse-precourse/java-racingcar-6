package racingcar.model;

import racingcar.validation.CarValidator;

public class Car {

    private final String carName;
    private Integer movingDistance;

    public static final Integer MOVE_CONDITION_MIN_NUMBER = 4;
    private static final Integer STARTING_LINE = 0;
    public static final Integer MOVE_ONE_STEP = 1;

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

    public Integer getMovingDistance() {
        return movingDistance;
    }

    @Override public String toString() {
        return carName;
    }
}
