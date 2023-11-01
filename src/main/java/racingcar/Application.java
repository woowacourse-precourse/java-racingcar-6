package racingcar;

import controller.RacingcarController;

public class Application {
    public static void main(String[] args) {
        RacingcarController racingcarController = new RacingcarController();
        racingcarController.gameStart();
    }
}
