package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void playGame() {
        String carNames = carNameProcess();
    }

    private String carNameProcess() {
        outputView.printInputCarNameMessage();
        return inputView.inputCarName();
    }
}
