package racingcar.controller;

import racingcar.service.CarService;

public class CarController {
    private final CarService service = new CarService();
    public void race(){
        service.race();
    }
}
