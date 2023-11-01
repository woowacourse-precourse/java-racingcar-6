package racingcar;

import racingcar.controller.RacingGameController;

public class Application {

    public static void main(String[] args) {
        // setting
        RacingGameController controller = new RacingGameController();

        // start application
        controller.run();
    }
}
