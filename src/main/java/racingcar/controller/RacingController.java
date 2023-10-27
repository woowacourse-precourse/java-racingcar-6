package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void runGame() {
        startGame();
    }

    private void startGame() {
        OutputView.printStartMessage();
        InputView.getPlayerInput();
    }
}
