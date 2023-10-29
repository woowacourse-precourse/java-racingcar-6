package racingcar.controller;

import racingcar.iosystem.InputView;
import racingcar.iosystem.OutputView;
import racingcar.utill.RunGame;

public class RacingGame {
    public RacingGame() {
        InputView inputView = new InputView(InputView
                .setCarsName(InputView
                        .inputCar()));
        RunGame runGame = new RunGame();
        runGame.run(inputView);
        OutputView.endGameResult(inputView.getCarMove(), inputView.getCars());
    }
}
