package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {
    private final InputView inputView;
    private final OutputView outputView;

    public GamePlay() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void runGame() {
        List<Car> cars = addCarNames();
        List<String> scores = createScoreBoard(cars);

        int inputRoundNum = inputView.inputRoundNum();

        outputView.printBlank();
        outputView.printRoundResult();
        showCurrentScores(cars, scores, inputRoundNum);

        showWinners(cars, scores);
    }

    public List<Car> addCarNames() {
        List<String> carNamesInput = inputView.inputCarNames();
        List<Car> carNames = new ArrayList<>();
        for (String name:carNamesInput) {
            carNames.add(new Car(name));
        }
        return carNames;
    }

    private static List<String> createScoreBoard(List<Car> cars) {
        List<String> scores = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            scores.add("");
        }
        return scores;
    }

    public List<String> countScore(List<Car> cars, List<String> scores) {
        for (int i = 0; i < cars.size(); i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                scores.set(i, scores.get(i) + "-");
                cars.get(i).move(randomNum);
            }
        }
        return scores;
    }

    private void showCurrentScores(List<Car> cars, List<String> scores, int inputRoundNum) {
        for (int i = 0; i < inputRoundNum; i++) {
            countScore(cars, scores);
            for (int j = 0; j < cars.size(); j++) {
                System.out.println(cars.get(j) + " : " + scores.get(j));
            }
            System.out.println();
        }
    }

    private void showWinners(List<Car> cars, List<String> scores) {
        List<Car> winners = new ArrayList<>();
        int lastMaxScore = 0;
        for (int i = 0; i < cars.size(); i++) {
            int eachLastScore = scores.get(i).length();
            if (lastMaxScore <= eachLastScore) {
                lastMaxScore = eachLastScore;
            }
        }

        for (int i = 0; i < cars.size(); i++) {
            if (lastMaxScore == scores.get(i).length()) {
                winners.add(cars.get(i));
            }
        }
        outputView.printWinners(winners);
    }

}
