package racingcar;

import racingcar.controller.RacingCarGameController;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingGame = new RacingCarGameController();

        racingGame.start();
        racingGame.inProgress();
        racingGame.end();
    }
}
