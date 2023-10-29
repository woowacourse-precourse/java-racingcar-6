package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {

    private final RacingGameService racingGameService;

    public RacingCarGame(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void run() {
        initRacingGame();
        racingGamePlay();
        displayWinner();
    }

    private void initRacingGame() {
        String[] carNameArr = splitCarNames(InputView.carNames());
        Validator.inputCarNames(carNameArr);
        racingGameService.init(carNameArr);
    }

    private void racingGamePlay() {
        String attemptCount = InputView.askForAttemptCount();
        Validator.isInteger(attemptCount);
        int count = Integer.parseInt(attemptCount);
        racingGameService.playGame(count);
    }

    private void displayWinner() {
        String winningCarNames = racingGameService.getWinningCar();
        OutputView.printWinningCar(winningCarNames);
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }
}
