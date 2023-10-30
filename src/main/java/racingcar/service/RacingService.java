package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Attempt;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingService {

    private Cars cars;
    private Attempt attempt;

    public List<String> saveCarNames(String carNames) {
        cars.addCar(carNames);
        return cars.getCarNames();
    }

    public void saveAttemptNumber(String attemptNumber) {
        attempt = new Attempt(attemptNumber);
    }

    public boolean isContinue() {
        return attempt.isContinue();
    }

    public Map<String, Integer> race() {
        List<String> carNames = cars.getCarNames();
        carNames.stream()
                .filter(c -> generateRandomNumber()>3)
                .forEach(c -> cars.increaseCarScore(c));
        attempt.increaseAttemptCount();
        return cars.getCarScores();
    }



    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
