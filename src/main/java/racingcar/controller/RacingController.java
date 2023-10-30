package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {

    public static void startRacing() {
        RacingService.initRacing();
        RacingService.progressRacing();
        RacingService.finishRacing();
    }
}
