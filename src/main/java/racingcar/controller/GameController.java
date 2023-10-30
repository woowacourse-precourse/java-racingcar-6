package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.ControlTowerService;
import racingcar.view.InputView;

public class GameController {

    private final ControlTowerService controlTowerService;

    public GameController(ControlTowerService controlTowerService) {
        this.controlTowerService = controlTowerService;
    }

    public List<Car> addCarNames(String inputCarNames) {
        return controlTowerService.inputCarNames(inputCarNames);
    }
}
