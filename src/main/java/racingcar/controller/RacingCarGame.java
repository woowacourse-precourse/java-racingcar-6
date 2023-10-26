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
        Validator.InputCarNames(carNameArr);
        racingGameService.init(carNameArr);
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }
}
