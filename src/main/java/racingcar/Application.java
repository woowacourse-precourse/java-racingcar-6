package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.RacingGameController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        // setting
        GameController controller = new GameController(
                new RacingGameController(),
                new InputView());

        // start application
        controller.run();
    }
}
