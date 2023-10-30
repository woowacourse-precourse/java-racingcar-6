package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.ControlTowerService;

public class GameController {

    private final ControlTowerService controlTowerService;

    public GameController(ControlTowerService controlTowerService) {
        this.controlTowerService = controlTowerService;
    }

    public List<Car> addCarNames(String inputCarNames) {
        return controlTowerService.inputCarNames(inputCarNames);
    }

    public int addRoundNumber(String inputRoundNumber) {
        return controlTowerService.saveRoundNumber(inputRoundNumber);
    }
}
