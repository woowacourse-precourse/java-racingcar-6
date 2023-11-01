package racingcar.configuration;

import racingcar.controller.GameController;
import racingcar.service.RacingGameService;
import racingcar.service.domain.CarEngine;
import racingcar.service.domain.WootecoCarEngine;
import racingcar.view.ConsoleInput;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ApplicationConfiguration {

    public GameController gameController() {
        return new GameController(outputView(), inputView(), racingGameService(), carEngine());
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputView inputView() {
        return new InputView(new ConsoleInput());
    }

    private RacingGameService racingGameService() {
        return new RacingGameService();
    }

    private CarEngine carEngine() {
        return new WootecoCarEngine();
    }
}
