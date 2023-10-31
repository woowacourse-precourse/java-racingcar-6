package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // setting
        GameController controller = new GameController(
                new RacingGameController(),
                new InputView(),
                new OutputView());

        // start application
        controller.run();
    }
}
