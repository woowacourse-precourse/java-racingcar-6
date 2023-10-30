package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingPlayService;

public class RacingController {

    RacingPlayService racingPlayService;


    public void playRacingWith(Cars racingCars) {
        racingPlayService.playRacingWith(racingCars);
    }

}
