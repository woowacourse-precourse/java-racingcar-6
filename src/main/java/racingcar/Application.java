package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceGameController controller = new RaceGameController();
        controller.startGame();

    }
}
