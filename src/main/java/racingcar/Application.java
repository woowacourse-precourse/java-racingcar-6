package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = AppConfig.racingCarController();
        racingCarController.startGame();
    }
}
