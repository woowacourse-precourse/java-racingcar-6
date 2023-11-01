package racingcar.controller;

import racingcar.model.Cars;
import racingcar.service.RacingCarGameService;

public class RacingCarGameController {

    private final RacingCarGameService racingCarGameService;

    public RacingCarGameController() {
        racingCarGameService = new RacingCarGameService();
    }
    public void fowardCars(Cars cars){
        racingCarGameService.fowardCars(cars);
    }

    public int getMaxStep(Cars cars){
        return racingCarGameService.getMaxStep(cars);
    }
}
