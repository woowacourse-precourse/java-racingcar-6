package racingcar;

import racingcar.controller.Controller;

public class RacingCarGame {
    public static void startGame() {
        Controller controller = new Controller();

        controller.initCarName();
        controller.execute(controller.initTrial());
        controller.printResult();
    }
}
