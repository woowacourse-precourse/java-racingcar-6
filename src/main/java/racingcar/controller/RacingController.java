package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.service.RacingPlayService;

public class RacingController {

    RacingPlayService racingPlayService;


    public void playRacingWith(RacingCars racingCars) {
        racingPlayService.playRacingWith(racingCars);
    }

}
