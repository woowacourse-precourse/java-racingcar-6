package racingcar.controller;

import racingcar.model.Attempts;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame implements Game {
    private final Cars cars;
    private final Attempts attempts;

    public RacingGame() {
        cars = new Cars(collectCarNames());
        attempts = new Attempts(collectNumberOfAttempts());
    }

    @Override
    public void run() {
        playRacingGame();
        announceWinners();
    }

    private String collectCarNames() {
        OutputView.printCarNameInputMessage();
        return InputView.carNamesInput();
    }

    private String collectNumberOfAttempts() {
        OutputView.printNumberOfAttemptsInputMessage();
        return InputView.numberOfAttemptsInput();
    }

    private void playRacingGame() {
        OutputView.printPlayResultMessage();
        int currentAttempt = 0;
        while (attempts.getNumber() > currentAttempt) {
            cars.everyCarMoveForwardByRandom();
            OutputView.printPlayResult(cars.getCars());
            currentAttempt++;
        }
    }

    private void announceWinners() {
        final Winners winners = new Winners(cars);
        OutputView.printWinners(winners.getWinnersNames());
    }
}
