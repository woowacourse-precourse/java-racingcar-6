package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new RaceGameController(new InputView(), new OutputView()).run();
    }
}
