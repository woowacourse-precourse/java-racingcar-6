package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void start() {
        OutputView.printStartMessage();
        List<String> carName = InputView.readCarName();
    }
}
