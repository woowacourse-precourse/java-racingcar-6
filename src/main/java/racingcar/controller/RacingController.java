package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {
    private RacingService racingService = new RacingService();

    public void run() {
        setGame();
    }

    private void setGame() {
        racingService.initializeGame();
    }
}
