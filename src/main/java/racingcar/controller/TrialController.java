package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrialController {
    private static final int RANDOM_GENERATE_START_NUMBER = 0;
    private static final int RANDOM_GENERATE_END_NUMBER = 9;
    private static final int GO_OR_STOP_NUMBER = 4;

    public void applyTrialResult(Cars cars) {
        List<Boolean> movementResult;
        movementResult = Stream.generate(this::calculateMovement)
                .limit(cars.getNumberOfCars())
                .collect(Collectors.toList());
        cars.updateCarsPosition(movementResult);
    }

    public boolean calculateMovement() {
        return generateRandomNumber() >= GO_OR_STOP_NUMBER;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_GENERATE_START_NUMBER, RANDOM_GENERATE_END_NUMBER);
    }
}
