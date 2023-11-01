package racingcar.application;

import racingcar.controller.RacingCarController;
import racingcar.service.Accelerator;
import racingcar.service.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputView;
import racingcar.view.OutputViewImpl;

public class RacingCarApplication {
    public void run() {
        Accelerator accelerator = new Accelerator(new RandomNumberGenerator());
        InputView inputView = new InputViewImpl();
        OutputView outputView = new OutputViewImpl();
        RacingCarController racingCarController = new RacingCarController(accelerator, inputView, outputView);
        racingCarController.run();
    }
}
