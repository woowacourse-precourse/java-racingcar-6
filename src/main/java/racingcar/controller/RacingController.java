package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {

    RacingService racingService = new RacingService();

    public void run() {
        initRacing();
    }

    private void initRacing() {
        racingService.initRacing();
    }
}
