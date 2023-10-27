package racingcar.factory;

import racingcar.controller.RacingCarController;
import racingcar.io.OutputView;

public class ComponentFactory {

    public RacingCarController racingCarController() {
        return new RacingCarController(outputView());
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
