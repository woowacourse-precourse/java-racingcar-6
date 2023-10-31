package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.service.RacingCarGameService;
import racingcar.view.in.GameInputView;
import racingcar.view.out.GameOutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController =
                new RacingCarGameController(
                        new RacingCarGameService(),
                        new GameInputView(),
                        new GameOutputView()
                );
        racingCarGameController.start();
    }
}
