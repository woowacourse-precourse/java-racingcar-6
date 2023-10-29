package racingcar;

import racingcar.controller.Controller;

public class RacingGame {
    Controller controller;

    public RacingGame() {
        this.controller = Controller.getInstance();
    }

    public void run() {
        controller.settingGame();
        controller.startGame();
        controller.printFinalResult();
    }


}
