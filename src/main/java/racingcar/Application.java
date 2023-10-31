package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new InputView());
        racingCarController.run();
    }
}
