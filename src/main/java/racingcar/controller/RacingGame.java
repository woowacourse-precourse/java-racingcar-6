package racingcar.controller;

import racingcar.service.Referee;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final Referee referee;
    private final InputView inputView = new InputView(new Validator());

    public RacingGame(Referee referee) {
        this.referee = referee;
    }

    public void run() {
        collectCarNames();
        collectNumberOfAttempts();
        playRacingGame();
        announceWinners();
    }

    public void collectCarNames() {
        OutputView.printCarNameInputMessage();
        String carNames = inputView.carNamesInput();
        referee.addCars(carNames);
    }

    public void collectNumberOfAttempts() {
        OutputView.printNumberOfAttemptsInputMessage();
        referee.setAttempts(inputView.numberOfAttemptsInput());
    }

    public void playRacingGame() {
        OutputView.printPlayResultMessage();
        while (!referee.anyCarReaches()) {
            OutputView.printPlayResult(referee.getPlayResults());
        }
    }

    public void announceWinners() {
        OutputView.printWinners(referee.getWinnersNames());
    }
}
