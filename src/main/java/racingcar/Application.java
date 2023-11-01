package racingcar;

import racingcar.controller.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new RacingGame(InputView.getInstance(), OutputView.getInstance()).start();
    }
}
