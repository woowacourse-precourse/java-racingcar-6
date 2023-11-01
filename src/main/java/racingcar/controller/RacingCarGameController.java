package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    public void start() {
        String nameData = InputView.askName();
        String TryNumberData = InputView.askTryNumber();
    }

    public void inProgress() {
        OutputView.displayResult();
    }

    public void end() {
        OutputView.displayWinner();
    }
}
