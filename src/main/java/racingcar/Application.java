package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingController racingController = new RacingController(new InputView(), new OutputView());
        racingController.play();
    }
}
