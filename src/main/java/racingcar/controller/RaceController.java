package racingcar.controller;

import racingcar.domain.CarNames;
import racingcar.view.InputView;

public class RaceController {
    InputView inputView = new InputView();

    public void runGame() {
        CarNames carNames = CarNames.from(inputView.readCarNames());

    }
}
