package racingcar.controller;

import racingcar.domain.Car;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class GameController {

    public static List<String> getCarNames() {
        String input = InputView.readFromUser();
        return Validator.validateCarNames(input);
    }

    public static int getTotalRound() {
        String input = InputView.readFromUser();
        return Validator.validateTotalRound(input);
    }

    public static void playRound(List<Car> cars, int totalRound) {
        for (Car car : cars) {
            car.play();
        }
    }

    public static void processResult(int totalRound, List<String> carNames, List<Car> cars) {
        Map<String, Integer> winnerResult = new HashMap<>();
        List<List<Integer>> roundScores = new ArrayList<>();

        for (Car car : cars) {
            roundScores.add(car.getCumulativeScoreList());
            winnerResult.put(car.getName(), car.getCurrentScore());
        }
        int topScore = Collections.max(winnerResult.values());

        List<String> winnerNames = winnerResult.entrySet().stream()
                .filter(entry -> entry.getValue() == topScore)
                .map(Map.Entry::getKey)
                .toList();

        OutputView.printResult(totalRound, carNames, roundScores, winnerNames);
    }
}
