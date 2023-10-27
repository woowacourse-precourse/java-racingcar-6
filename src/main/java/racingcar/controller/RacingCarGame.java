package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.validator.Validator;
import racingcar.view.InputView;

public class RacingCarGame {

    private final RacingGameService racingGameService;

    public RacingCarGame(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void run() {
        gameStart();
    }

    private void gameStart() {
        String[] carNameArr = splitCarNames(InputView.carNames());
        Validator.inputCarNames(carNameArr);
        racingGameService.init(carNameArr);
        String attemptCount = InputView.askForAttemptCount();
        Validator.isInteger(attemptCount);
        int count = Integer.parseInt(attemptCount);
        racingGameService.playGame(count);
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }
}
