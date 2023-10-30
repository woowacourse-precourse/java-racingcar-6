package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    public void play() {
        String[] carNames = InputView.readCarNames();
        int attemptCount = InputView.readAttemptCount();
        Cars cars = new Cars(carNames);
        OutputView.printResultLabel();
        for (int i = 0; i < attemptCount; i++) {
            cars.playOneRound();
            OutputView.printRoundResult(cars);
        }
        List<String> winnerList = cars.findWinner();
        OutputView.printFinalResult(winnerList);
    }
}
