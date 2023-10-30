package racingcar.controller;

import racingcar.view.ConsoleOutput;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        ConsoleOutput.displayMessage(ConsoleOutput.INPUT_MESSAGE);
        String input = inputView.getCarNames();
    }
}
