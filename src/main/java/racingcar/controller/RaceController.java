package racingcar.controller;

import racingcar.domain.CarNames;
import racingcar.domain.TryCount;
import racingcar.view.InputView;

public class RaceController {
    InputView inputView = new InputView();

    public void runGame() {
        CarNames carNames = CarNames.from(inputView.readCarNames());
        TryCount tryCount = new TryCount(inputView.readTryCount());
    }
}
