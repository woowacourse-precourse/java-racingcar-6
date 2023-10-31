package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {

    private final RacingService racingService = new RacingService();

    public void run() {
        racingService.play();
    }
}
