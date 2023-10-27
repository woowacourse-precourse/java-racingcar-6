package racingcar.controller;

import racingcar.util.NumberGenrator;
import racingcar.util.RandomNumberGenrator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static NumberGenrator randomNUmberGenerator = new RandomNumberGenrator();

    public void start() {
        outputView.printCarNameInputMessage();
        String carNames = inputView.readCarNames();
        outputView.printTryCountInputMessage();
        int tryCount = inputView.readTryCount();
    }
}
