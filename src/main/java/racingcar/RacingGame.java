package racingcar;

import racingcar.Controller.Controller;

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
