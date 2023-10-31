package racingcar;

import racingcar.domain.controller.RacingGameController;
import racingcar.service.RacingGameService;

public class Application {

    static RacingGameController racingGameController = new RacingGameController();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        racingGameController.playRacingGame();
    }
}
