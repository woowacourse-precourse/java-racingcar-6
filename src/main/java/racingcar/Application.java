package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new InputView(), new OutputView(),
                new RacingCarService());

        racingCarController.racingGame();

    }
}
