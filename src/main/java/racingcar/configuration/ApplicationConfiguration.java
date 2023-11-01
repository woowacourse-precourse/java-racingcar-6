package racingcar.configuration;

import racingcar.controller.GameController;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ApplicationConfiguration {

    public GameController gameController() {
        return new GameController(outputView(), inputView(), racingGameService());
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputView inputView() {
        return new InputView();
    }

    private RacingGameService racingGameService() {
        return new RacingGameService();
    }
}
