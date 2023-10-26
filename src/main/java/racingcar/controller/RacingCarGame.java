package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarGame {

    public void run() {
        gameStart();
    }

    private void gameStart() {
        String[] carNameArr = splitCarNames(InputView.carNames());
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }
}
