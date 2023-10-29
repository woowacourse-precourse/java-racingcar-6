package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        makeCars();
    }

    private void makeCars() {
        outputView.printNamesGuide();
        String carNames = inputView.readCarNames();
    }

}
