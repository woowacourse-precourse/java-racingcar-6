package racingcar;

import racingcar.domain.game.controller.RacingGameController;
import racingcar.domain.game.service.RacingGameServiceImpl;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController =
                new RacingGameController(new RacingGameServiceImpl());

        racingGameController.run();
    }

}
