package racingcar;

import racingcar.Controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingController = new RacingGameController();
        racingController.runGame();
    }
}
