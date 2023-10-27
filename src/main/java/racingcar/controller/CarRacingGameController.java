package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarRacingGameService;
import racingcar.util.ConsoleIO;

public class CarRacingGameController {
    private final CarRacingGameService carRacingGameService;

    public CarRacingGameController() {
        carRacingGameService = new CarRacingGameService();
    }

    public void run() {
        Car cars = carRacingGameService.getCar(ConsoleIO.readCarName());
    }
}
