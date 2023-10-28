package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public RacingcarController racingcarController() {
        return new RacingcarController(inputView(), outputView());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
