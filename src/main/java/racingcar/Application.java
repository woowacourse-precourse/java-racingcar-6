package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.RacingView;

public class Application {

    private static final RacingController racingController = new RacingController(new RacingView());

    public static void main(String[] args) {
        racingController.startRacing();
    }
}
