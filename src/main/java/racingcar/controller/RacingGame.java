package racingcar.controller;

import racingcar.model.GameSetting;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame implements Game {

    private final GameSetting gameSetting;
    public RacingGame() {
        this.gameSetting = new GameSetting(collectCarNames(), collectNumberOfAttempts());
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
        while (gameSetting.getAttempts().getNumber() > currentAttempt) {
            gameSetting.getCars().everyCarMoveForwardByRandom();
            OutputView.printPlayResult(gameSetting.getCars().getCars());
            currentAttempt++;
        }
    }

    private void announceWinners() {
        final Winners winners = new Winners(gameSetting.getCars());
        OutputView.printWinners(winners.getWinnersNames());
    }
}
