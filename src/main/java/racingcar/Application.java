package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.RandomCarEngine;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarOutputView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(
                new RacingCarInputView(),
                new RacingCarOutputView(),
                new RacingCarService(new RandomCarEngine())
        );
        racingController.run();
    }
}
