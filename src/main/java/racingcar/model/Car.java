package racingcar.model;

import racingcar.constant.RacingGameConstants;

public class Car {
    private final CarName carName;
    private int position;

    public Car(String name) {
        this.carName = new CarName(name);
        position = 0;
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void tryToMove(int randomNumber) {
        if (randomNumber >= RacingGameConstants.MOVABLE_THRESHOLD) {
            moveOneStep();
        }
    }

    public void moveOneStep() {
        position++;
    }
}
