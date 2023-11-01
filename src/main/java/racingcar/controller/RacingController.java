package racingcar.controller;

import racingcar.service.RaceService;

public class RacingController {

    RaceService raceService;

    public RacingController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void run() {
        raceService.init();
        raceService.play();
    }
}
