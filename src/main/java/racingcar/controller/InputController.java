package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import racingcar.model.domain.Car;
import racingcar.model.service.InputService;

public class InputController {
    private InputService inputService;
    private Car car;

    public InputController(InputService inputService, Car car) {
        this.inputService = inputService;
        this.car = car;
    }

    public Map<String, Integer> receiveCarName() {
        String carName = Console.readLine();
        Map<String, Integer> carNameMap = inputService.validateCarName(carName);
        return carNameMap;
    }
}
