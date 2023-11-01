package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.view.InputMapper;
import racingcar.view.OutputMaker;
import racingcar.view.RacingView;

public class RacingConfig {

    private RacingConfig() {

    }

    public static RacingController getRacingController() {
        InputMapper inputMapper = getInputMapper();
        OutputMaker outputMaker = getOutputMaker();
        return new RacingController(getRacingView(inputMapper, outputMaker));
    }

    private static InputMapper getInputMapper() {
        return new InputMapper();
    }

    private static OutputMaker getOutputMaker() {
        return new OutputMaker();
    }

    private static RacingView getRacingView(InputMapper inputMapper, OutputMaker outputMaker) {
        return new RacingView(inputMapper, outputMaker);
    }
}
