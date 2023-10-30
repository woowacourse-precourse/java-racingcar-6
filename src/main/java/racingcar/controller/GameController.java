package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RandomReferee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final Cars cars;
    private int trialCount;

    public GameController() {
        this.cars = new Cars(new ArrayList<>());
    }

    public void run() {
        init();
        playRace();
        displayGameResult();
    }

    private void playRace() {
        OutputView.printPlayResult();
        while (trialCount > 0) {
            cars.move(new RandomReferee());
            trialCount--;
            OutputView.printRaceResult(cars.getStringOfRaceResult());
        }
    }

    private void displayGameResult() {
        List<String> winnerNames = cars.getWinnerNameList();
        OutputView.printWinner(winnerNames);
    }

    private void init() {
        List<String> carNameList = InputView.getCarNameList();
        carNameList.forEach(cars::add);
        this.trialCount = InputView.getTrialCount();
    }

}
