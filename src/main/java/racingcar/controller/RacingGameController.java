package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;

public class RacingGameController {

    InputView inputView = new InputView();

    public void run() {
        List<String> carNames = inputView.readCarNames();

    }
}
