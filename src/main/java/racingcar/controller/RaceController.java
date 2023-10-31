package racingcar.controller;

import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.domain.RacingCarGame;

public class RaceController {

    public void run() {
        InputView view = new InputView();
        RacingCarGame racingCarGame = new RacingCarGame(new Referee());
        String carNames = view.inputCarNames();

        Integer tryCount = view.inputHowManyTry();
        StringBuilder game = racingCarGame.gameStart(carNames, tryCount);

        OutputView outputView = new OutputView();
        outputView.printGameResult(game);
    }
}
