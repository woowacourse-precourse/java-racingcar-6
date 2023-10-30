package racingcar.controller;

import racingcar.service.RacingCarService;

public class RacingCarGame {
    public void run() {
        RacingCarService racingCarService = new RacingCarService();
        racingCarService.start();
    }
}
