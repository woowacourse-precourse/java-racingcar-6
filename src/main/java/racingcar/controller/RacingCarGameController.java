package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.handler.InputHandler;

import java.util.List;

public class RacingCarGameController {

    private final InputHandler inputHandler;

    public RacingCarGameController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        RacingCar racingCar = loadCarNames();
    }

    public RacingCar loadCarNames() {
        List<String> carNames = inputHandler.inputCarName();

        return new RacingCar(carNames);
    }
}
