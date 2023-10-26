package racingcar.controller;

import racingcar.validator.Validator;
import racingcar.view.InputView;

public class RacingCarGame {

    public void run() {
        gameStart();
    }

    private void gameStart() {
        String[] carNameArr = splitCarNames(InputView.carNames());
        Validator.InputCarNames(carNameArr);
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }
}
