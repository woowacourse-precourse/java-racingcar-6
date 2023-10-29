package racingcar.controller;

import racingcar.service.RacingService;

public class ProgressController {
    private final RacingService racingService;

    public ProgressController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void gameProgress() {
        racingService.gameProgress();
        racingService.gameResult();
    }
}
