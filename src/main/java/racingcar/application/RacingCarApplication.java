package racingcar.application;

import racingcar.controller.RacingCarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputViewImpl;

public class RacingCarApplication {
    public void run() {
        InputView inputView = new InputViewImpl();
        OutputView outputView = new OutputViewImpl();

        RacingCarController racingCarController = new RacingCarController(inputView, outputView);
        racingCarController.run();
    }
}

