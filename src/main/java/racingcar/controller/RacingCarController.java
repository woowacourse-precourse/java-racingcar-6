package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarService racingCarService;

    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarService racingCarService, RacingCarView racingCarView) {
        this.racingCarService = racingCarService;
        this.racingCarView = racingCarView;
    }

}
