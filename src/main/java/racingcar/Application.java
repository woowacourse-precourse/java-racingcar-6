package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        new RacingGameController().run();
    }
}
