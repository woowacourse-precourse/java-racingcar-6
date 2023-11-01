package racingcar.model;

import racingcar.constant.RacingGameConstants;
import racingcar.utils.NumberGenerator;

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

    public void tryToMove(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generateInteger();
        if (randomNumber >= RacingGameConstants.MOVABLE_THRESHOLD) {
            position++;
        }
    }
}
