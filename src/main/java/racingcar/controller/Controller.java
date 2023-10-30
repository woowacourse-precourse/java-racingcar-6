package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public interface Controller {
    static RacingGameController generateRacingGameController(InputView inputView, OutputView outputView) {
        return new RacingGameController(inputView, outputView);
    }
}
