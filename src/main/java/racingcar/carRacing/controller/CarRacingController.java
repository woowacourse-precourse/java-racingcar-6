package racingcar.carRacing.controller;

import static racingcar.carRacing.service.CarRacingResultService.printRacingResult;

import racingcar.carRacing.model.CarRacing;
import racingcar.carRacing.service.CarRacingGameService;

public class CarRacingController {
    
    private CarRacing carRacing;

    private final CarRacingGameService carRacingGameService;

    public CarRacingController(CarRacing carRacing) {
        this.carRacing = carRacing;
        this.carRacingGameService = new CarRacingGameService(carRacing);
    }

    public void run() {
        carRacingGameService.waitInput();
        carRacingGameService.doRace();
        printRacingResult(carRacing);
    }

}
