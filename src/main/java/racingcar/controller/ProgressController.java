package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingService;

public class ProgressController {
    private final RacingService racingService;

    public ProgressController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void gameProgress() {
        racingService.gameProgress();
        racingService.gameResult();
        Console.close();
    }
}
