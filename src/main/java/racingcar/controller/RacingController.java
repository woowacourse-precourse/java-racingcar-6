package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {
    private RacingService racingService = new RacingService();

    public void run() {
        setGame();
        playGame();
    }

    private void playGame() {
        racingService.play();
    }

    private void setGame() {
        racingService.initializeGame();
    }
}
