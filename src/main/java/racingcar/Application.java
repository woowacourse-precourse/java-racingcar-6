package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputManager;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = RacingController.getRacingController();
        racingController.runRacing();
    }
}
