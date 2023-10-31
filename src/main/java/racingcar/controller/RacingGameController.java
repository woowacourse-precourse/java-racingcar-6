package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;
import racingcar.service.CarService;
import racingcar.service.TryService;

public class RacingGameController {


    private final CarService carService;
    private final TryService tryService;

    private RacingCars racingCars;

    private TryCount tryCount;

    public RacingGameController(){
        carService = new CarService();
        tryService = new TryService();
    }
    public void start(){
        racingCars = carService.getCarNames();
        tryCount = tryService.getTryCount();

    }
}
