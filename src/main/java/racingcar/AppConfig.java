package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public static RacingCarController racingCarController() {
        return new RacingCarController(racingCarService(),inputView(),outputView());
    }

    public static RacingCarService racingCarService() {
        return new RacingCarService();
    }

    public static InputView inputView() {
        return new InputView();
    }

    public static OutputView outputView() {
        return new OutputView();
    }
}
