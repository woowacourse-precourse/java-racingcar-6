package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final Cars cars;
    private int trialCount;

    public GameController() {
        this.cars = new Cars();
    }

    public void run() {
        init();
        playRace();
        displayGameResult();
    }

    private void playRace() {
        OutputView.printPlayResult();
        while (trialCount > 0) {
            cars.move();
            trialCount--;
            OutputView.printRaceResult(cars.getStringOfRaceResult());
        }
    }

    private void displayGameResult() {
        int winnerPosition = cars.getMaxPosition();
        List<String> winnerNames = cars.getCarNameListByPosition(winnerPosition);
        OutputView.printWinner(winnerNames);
    }

    private void init() {
        List<String> carNameList = InputView.getCarNameList();
        carNameList.forEach(cars::add);
        this.trialCount = InputView.getTrialCount();
    }

}
