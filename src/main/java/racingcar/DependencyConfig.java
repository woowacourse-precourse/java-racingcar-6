package racingcar;

import racingcar.controller.GameController;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class DependencyConfig {

    public GameController gameController() {
        return new GameController(inputView(), outputView(), racingService());
    }

    private InputView inputView() {
        return InputView.getInstance();
    }

    private OutputView outputView() {
        return OutputView.getInstance();
    }

    private RacingService racingService() {
        return RacingService.getInstance();
    }
}
