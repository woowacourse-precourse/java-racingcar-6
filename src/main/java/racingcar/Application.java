package racingcar;

import racingcar.controller.RacingcarController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final RacingcarController racingcarController = new RacingcarController();
        racingcarController.startGame();
    }
}
