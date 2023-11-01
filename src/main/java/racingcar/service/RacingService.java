package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingService {

    private final Validator validator = new Validator();
    private Cars cars;
    private Attempt attempt;

    private static final int PROGRESS_VALUE = 4;

    public void saveCarNames(String carNames) {
        validator.validateCarNames(carNames);
        cars = new Cars(carNames);
    }

    public void saveAttemptNumber(String attemptNumber) {
        validator.validateAttemptNumber(attemptNumber);
        attempt = new Attempt(attemptNumber);
    }

    public boolean isContinue() {
        return attempt.isContinue();
    }

    public Map<String, Integer> race() {
        raceRound();
        attempt.increaseAttemptCount();
        return cars.getCarScores();
    }

    public List<String> getCarNamesList() {
        return cars.getCarNames();
    }

    public List<String> findWinners(){
        List<String> winners = new ArrayList<>();
        int bestScore = cars.getBestScore();
        Map<String, Integer> carsScore = cars.getCarScores();
        cars.getCarNames().stream()
                .filter(carName -> carsScore.get(carName).equals(bestScore))
                .forEach(winners::add);
        return winners;
    }

    private void raceRound(){
        List<String> carNames = cars.getCarNames();
        carNames.stream()
                .filter(carName -> generateRandomNumber() >= PROGRESS_VALUE)
                .forEach(carName -> cars.moveForward(carName));
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }


}
