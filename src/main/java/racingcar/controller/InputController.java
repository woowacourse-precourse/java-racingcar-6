package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import racingcar.model.domain.Car;
import racingcar.model.service.InputService;

public class InputController {
    private InputService inputService;

    public InputController(InputService inputService) {
        this.inputService = inputService;
    }

    public Map<String, Integer> receiveCarName() {
        String carName = Console.readLine();
        Map<String, Integer> carNameMap = inputService.validateCarName(carName);
        return carNameMap;
    }

    public int receiverNumberOfAttempts() {
        String numberOfAttempts = Console.readLine();
        return inputService.validateNumberOfAttempts(numberOfAttempts);
    }

    public void doRace(Car car) {
        inputService.doRace(car);
    }

    public String choiceWinner(Car car) {
        return inputService.choiceWinner(car);
    }
}
