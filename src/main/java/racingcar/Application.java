package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.RacingView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new RacingView());
        racingController.start();
    }
}
