package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        RaceGameController controller = new RaceGameController();
        controller.startGame();

    }
}
