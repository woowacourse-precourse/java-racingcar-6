package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void runRacingGame() {
        RacingGame racingGame = new RacingGame(new InputView(), new OutputView(), new Referee());
        racingGame.run();
    }


}
