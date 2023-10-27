package racingcar.controller;

import racingcar.view.InputView;
import racingcar.model.RacingCarGame;

public class GameController {

    private static int round;

    public static void run() {
        String[] carNames = InputView.inputCarNames();
        RacingCarGame racingCarGame = RacingCarGame.from(carNames);

        round = InputView.inputRoundNumber();
    }
}
