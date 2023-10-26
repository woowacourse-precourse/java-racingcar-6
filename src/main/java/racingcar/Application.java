package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarController racingCarController = new RacingCarController(new InputView());
        racingCarController.run();
    }
}
