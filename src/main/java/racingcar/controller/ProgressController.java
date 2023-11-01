package racingcar.controller;

import racingcar.service.RacingService;

import java.util.List;

public class ProgressController {
    private final RacingService racingService;

    public ProgressController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void gameProgress() {
        racingService.gameProgress();
        List winners = racingService.chooseWinner();
        racingService.gameResult(winners);
    }
}
