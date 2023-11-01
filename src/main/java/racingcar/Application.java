package racingcar;

import racingcar.controller.RacingGameController;

public class Application {

    static RacingGameController racingGameController = new RacingGameController();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        racingGameController.playRacingGame();
    }
}
