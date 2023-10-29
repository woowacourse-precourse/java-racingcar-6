package racingcar.controller;

import racingcar.domain.TryCount;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private TryCount generateTryCount() {
        final String input = inputView.inputTryCount();
        final int tryCount = InputParser.tryCountParser(input);
        return new TryCount(tryCount);
    }
}
