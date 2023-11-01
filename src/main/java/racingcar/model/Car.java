package racingcar.model;

import racingcar.validation.CarValidator;

public class Car {

    private final String name;
    private Integer travelDistance;

    public static final Integer MIN_NUMBER_ALLOWED_TO_MOVE = 4;
    public static final Integer ONE_STEP = 1;
    private static final Integer STARTING_LINE = 0;

    public Car(String name) {
        CarValidator.validateCarName(name);
        this.name = name;
        this.travelDistance = STARTING_LINE;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= MIN_NUMBER_ALLOWED_TO_MOVE) {
            this.travelDistance += ONE_STEP;
        }
    }

    public Integer getTravelDistance() {
        return travelDistance;
    }

    @Override public String toString() {
        return name;
    }
}
