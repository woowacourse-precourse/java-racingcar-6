package racingcar;

import racingcar.controller.Controller;
import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = Controller.generateRacingGameController();
        racingGameController.gameStart();
    }
}
