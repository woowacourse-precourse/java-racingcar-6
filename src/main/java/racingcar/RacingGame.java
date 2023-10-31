package racingcar;

import racingcar.controller.Controller;

public class RacingGame {
    private final Controller controller;

    public RacingGame() {
        this.controller = new Controller();
    }

    public void run() {
        controller.setting();
        controller.play();
        controller.finish();
    }

}
