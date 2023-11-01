package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputMaker;
import racingcar.view.RacingView;

public class RacingConfig {

    private RacingConfig() {

    }

    public static RacingController getRacingController() {
        InputView inputView = getInputView();
        OutputMaker outputMaker = getOutputMaker();
        return new RacingController(getRacingView(inputView, outputMaker));
    }

    private static InputView getInputView() {
        return new InputView();
    }

    private static OutputMaker getOutputMaker() {
        return new OutputMaker();
    }

    private static RacingView getRacingView(InputView inputView, OutputMaker outputMaker) {
        return new RacingView(inputView, outputMaker);
    }
}
