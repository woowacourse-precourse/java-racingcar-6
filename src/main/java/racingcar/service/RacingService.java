package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Attempt;
import racingcar.model.Cars;

public class RacingService {

    private Cars cars;
    private Attempt attempt;

    public void saveCarNames(String carNames) {
        cars.addCar(carNames);
    }

    public void saveAttemptNumber(String attemptNumber) {
        attempt = new Attempt(attemptNumber);
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
