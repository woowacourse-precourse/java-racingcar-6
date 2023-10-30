package racingcar.controller;

import racingcar.service.CarService;

public class RacingGameController {


    private final CarService carService;

    public RacingGameController(){
        carService = new CarService();
    }
    public void start(){
        carService.getCarNames();

    }
}
