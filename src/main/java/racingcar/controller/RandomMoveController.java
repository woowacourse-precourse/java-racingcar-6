package racingcar.controller;

import racingcar.model.Cars;
import racingcar.service.RandomNumbers;

public class RandomMoveController {
    private final RandomNumbers randomNumbers;

    public RandomMoveController(RandomNumbers randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public void moveForward(Cars cars) {
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (isForward(i)) {
                cars.moveForwardValueOf(i);
            }
        }
    }

    private Boolean isForward(int index) {
        int MOVEMENT_THRESHOLD = 4;
        return randomNumbers.isGreaterEqualThanValueOf(index, MOVEMENT_THRESHOLD);
    }

}
