package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void runRacingGame() {
        RacingGame racingGame = new RacingGame(new InputView(), new OutputView());
        racingGame.run();
    }


}
