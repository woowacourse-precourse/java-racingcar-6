package racingcar;

import racingcar.controller.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new InputView(), new OutputView());
        racingGame.run();
    }

}
