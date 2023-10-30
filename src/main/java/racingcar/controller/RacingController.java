package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {

    RacingService racingService = new RacingService();

    public void run() {
        initRacing();
        startRacing();
        selectWinner();
    }

    private void initRacing() {
        racingService.initRacing();
    }

    private void startRacing() {
        racingService.startRacing();
    }

    private void selectWinner() {
        racingService.selectWinner();
    }
}
