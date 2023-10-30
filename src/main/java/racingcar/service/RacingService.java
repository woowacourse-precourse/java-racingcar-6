package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Attempt;
import racingcar.model.Cars;
import racingcar.util.Parser;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingService {

    private final Parser parser = new Parser();
    private final Validator validator = new Validator();
    private Cars cars;
    private Attempt attempt;

    public List<String> saveCarNames(String carNames) {
        List<String> parsedCarNames = parser.parseCarNames(carNames);
        validator.validateCarNames(parsedCarNames);
        cars = new Cars(parsedCarNames);
        return cars.getCarNames();
    }

    public void saveAttemptNumber(String attemptNumber) {
        validator.validateAttemptNumber(attemptNumber);
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

    public List<String> getWinners(){
        List<String> winners = new ArrayList<>();
        int bestScore = cars.getBestScore();
        List<String> carNames = cars.getCarNames();
        Map<String, Integer> carScore = cars.getCarScores();
        for(String carName : carNames) {
            if(carScore.get(carName).equals(bestScore)) { // 키가 null이면 NullPointerException 예외 발생
                winners.add(carName);
            }
        }
        return winners;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
