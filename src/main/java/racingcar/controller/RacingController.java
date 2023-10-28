package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.InputService;
import racingcar.service.RacingService;

import java.util.List;

public class RacingController {
    private InputService inputService = new InputService();
    private RacingService racingService;
    public void gameStart() {
        List<Car> cars = inputService.inputCarName();
        int times = inputService.inputTimes();
        racingService = new RacingService(cars, times);
        racingService.gameProgress();
        racingService.gameResult();
    }

}
