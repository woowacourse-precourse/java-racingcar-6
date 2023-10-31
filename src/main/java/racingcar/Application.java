package racingcar;

import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        RacingGameController gameController = new RacingGameController();
        
        gameController.readyToPlay();
        gameController.play();
    }
}
