package racingcar.resolver;

import racingcar.controller.RacingCarController;
import racingcar.view.RacingCarView;

public class RacingCarRun {
    private final RacingCarController controller;
    private final RacingCarView view;

    public RacingCarRun() {
        this.controller = new RacingCarController();
        this.view = new RacingCarView();
    }


}
