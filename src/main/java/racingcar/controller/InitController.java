package racingcar.controller;

import racingcar.domain.Car;
import racingcar.dto.InitDto;
import racingcar.service.InputService;

import java.util.List;

public class InitController {
    private final InputService inputService;

    public InitController(InputService inputService) {
        this.inputService = inputService;
    }

    public InitDto gameInit() {
        List<Car> cars = inputService.inputCarName();
        int times = inputService.inputTimes();
        return new InitDto(cars, times);
    }

}
