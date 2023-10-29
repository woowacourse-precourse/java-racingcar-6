package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        RacingController racingController = new RacingController(inputView);
        racingController.run();
    }
}
