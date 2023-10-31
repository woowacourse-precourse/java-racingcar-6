package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.RacingView;

public class RacingConfig {

    private RacingConfig() {

    }

    public static RacingController getRacingController() {
        InputView inputView = getInputView();
        OutputView outputView = getOutputView();
        return new RacingController(getRacingView(inputView, outputView));
    }

    private static InputView getInputView() {
        return new InputView();
    }

    private static OutputView getOutputView() {
        return new OutputView();
    }

    private static RacingView getRacingView(InputView inputView, OutputView outputView) {
        return new RacingView(inputView, outputView);
    }
}
