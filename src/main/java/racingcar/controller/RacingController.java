package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {

    public static void start() {
        RacingService.doRacing();
    }
}
