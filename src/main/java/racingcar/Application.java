package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        RacingGameController mainController = new RacingGameController(InputView.getInstance(),
                OutputView.getInstance());

        mainController.run();
    }
}
