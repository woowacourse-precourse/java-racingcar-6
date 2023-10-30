package racingcar.controller;

import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.validator.InputValidator;

public class RacingCarController {
    private final RacingCarService racingCarService = new RacingCarService();

    public void start() {
        List<String> carList = racingCarService.inputCarList();
        InputValidator.validateCarList(carList);
    }
}
