package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.RacingGameServiceImpl;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController =
                new RacingGameController(new RacingGameServiceImpl());

        racingGameController.run();
    }
}
