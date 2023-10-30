package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    public void playGame() {
        String[] carNames = InputView.readCarNames();
        int attemptCount = InputView.readAttemptCount();
        Cars cars = new Cars(carNames);
        OutputView.printResultLabel();

        playRounds(attemptCount, cars);

        List<String> winnerNames = cars.findWinners();
        OutputView.printFinalResult(winnerNames);
    }

    private void playRounds(int attemptCount, Cars cars) {
        for (int i = 0; i < attemptCount; i++) {
            cars.playOneRound();
            OutputView.printRoundResult(cars);
        }
    }
}
