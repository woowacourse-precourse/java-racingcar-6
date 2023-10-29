package racingcar.controller;

import racingcar.domain.Car;
import racingcar.dto.GameSettingDto;
import racingcar.service.InputService;

import java.util.List;

public class InitController {
    private final InputService inputService;

    public InitController(InputService inputService) {
        this.inputService = inputService;
    }

    public GameSettingDto gameInit() {
        List<Car> cars = inputService.inputCarName();
        int times = inputService.inputTimes();
        return new GameSettingDto(cars, times);
    }

}
