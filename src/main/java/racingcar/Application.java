package racingcar;

import racingcar.controller.RacingcarController;

public class Application {
    public static void main(String[] args) {
        RacingcarController controller = new RacingcarController();
        controller.startGame();
    }
}