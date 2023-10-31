package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {
    private final RacingService racingService;

    public RacingController(RacingService racingService){
        this.racingService = racingService;
    }

    public void run(){
        racingService.initRacing();
        racingService.startRacing();
        racingService.announceWinner();
    }
}
