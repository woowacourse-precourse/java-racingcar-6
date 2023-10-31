package racingcar.controller;

import racingcar.iosystem.InputView;
import racingcar.iosystem.OutputView;
import racingcar.util.RunGame;

public class RacingGame {
    public RacingGame() {
        InputView inputView = new InputView();
        RunGame.run(inputView);
        OutputView.endGameResult(inputView.getCarMove(), inputView.getCars());
    }
}
