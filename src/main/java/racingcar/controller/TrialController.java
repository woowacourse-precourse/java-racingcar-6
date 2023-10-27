package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;

public class TrialController {
    private static final int RANDOM_GENERATE_START_NUMBER = 0;
    private static final int RANDOM_GENERATE_END_NUMBER = 9;
    private static final int GO_OR_STOP_NUMBER = 4;

    public void applyTrialResult(Cars cars) {
        cars.updateCarsPosition(calculateMovement());
    }

    public boolean calculateMovement() {
        return generateRandomNumber() >= GO_OR_STOP_NUMBER;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_GENERATE_START_NUMBER, RANDOM_GENERATE_END_NUMBER);
    }
}
