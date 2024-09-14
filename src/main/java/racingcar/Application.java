package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameController racingGameController = new RacingGameController(new InputView(), new OutputView());
        racingGameController.run();
    }
}
