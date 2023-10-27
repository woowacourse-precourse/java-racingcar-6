package racingcar.controller;

import racingcar.view.InputView;
import racingcar.model.RacingCarGame;

public class GameController {

    public static void run() {
        String[] carNames = InputView.inputCarNames();
        RacingCarGame racingCarGame = RacingCarGame.from(carNames);
    }
}
