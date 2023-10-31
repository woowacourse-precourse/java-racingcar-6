package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.service.CarService;

public class RacingGameController {


    private final CarService carService;

    private RacingCars racingCars;

    public RacingGameController(){
        carService = new CarService();
    }
    public void start(){
        racingCars = carService.getCarNames();

    }
}
