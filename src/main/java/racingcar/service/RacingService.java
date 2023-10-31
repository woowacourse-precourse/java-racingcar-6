package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.model.CarList;

public class RacingService {
    public void racingByTheNumberOfTrialCount(CarList racingCars) {
        List<Boolean> movementResult;
        movementResult = Stream.generate(this::calculateMovement)
                .limit(racingCars.getNumberOfCars())
                .collect(Collectors.toList());
        racingCars.updateCarsPosition(movementResult);
    }

    public boolean calculateMovement() {
        return generateRandomNumber() >= 4;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
