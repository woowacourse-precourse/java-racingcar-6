package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.view.RacingCarGameView;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController = new RacingCarGameController(new RacingCarGameView());
        racingCarGameController.run();
    }
}
