package racingcar;

import racingcar.controller.RacingController;

public class Application {

    public static void main(String[] args) {
        final RacingController game = new RacingController();
        game.start();
    }
}
