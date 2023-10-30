package racingcar;

import racingcar.controller.RacingController;
import view.InputMessage;
import view.OutputMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingController gameController = new RacingController();
        gameController.run();

    }
}
