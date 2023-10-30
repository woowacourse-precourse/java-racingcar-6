package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RefereeService;

public class GameController {

    private final RefereeService refereeService;

    public GameController(RefereeService refereeService) {
        this.refereeService = refereeService;
    }

    public List<Car> addCarNames(String inputCarNames) {
        return refereeService.inputCarNames(inputCarNames);
    }

    public int addRoundNumber(String inputRoundNumber) {
        return refereeService.saveRoundNumber(inputRoundNumber);
    }
}
