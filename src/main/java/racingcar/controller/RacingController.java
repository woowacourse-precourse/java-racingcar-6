package racingcar.controller;

import racingcar.service.CarFactoryService;

public class RacingController {

    CarFactoryService carFactoryService;

    public void createRacingCars(String racingCarString) {
        String[] cars = racingCarString.split(",");
        carFactoryService.createCars(cars);
    }



}
