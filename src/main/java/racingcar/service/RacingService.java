package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Attempt;
import racingcar.model.Cars;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingService {

    private Cars cars;
    private Attempt attempt;

    public void saveCarNames(String carNames) {
        cars.addCar(carNames);
    }

    public void saveAttemptNumber(String attemptNumber) {
        attempt = new Attempt(attemptNumber);
    }

    public boolean isContinue() {
        return attempt.isContinue();
    }

    public void race() {
        List<String> carNames = cars.getCarNames();
        carNames.stream()
                .filter(c -> generateRandomNumber()>3)
                .forEach(c -> cars.increaseCarScore(c));
        attempt.increaseAttemptCount();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
