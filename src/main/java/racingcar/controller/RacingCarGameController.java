package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.TryCount;
import racingcar.handler.InputHandler;

import java.util.List;

public class RacingCarGameController {

    private final InputHandler inputHandler;

    public RacingCarGameController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        RacingCar racingCar = loadCarNames();
        TryCount tryCount = loadTryCount();
    }

    public RacingCar loadCarNames() {
        List<String> carNames = inputHandler.inputCarNames();

        return new RacingCar(carNames);
    }

    public TryCount loadTryCount() {
        int tryCount = inputHandler.inputTryCount();

        return new TryCount(tryCount);
    }
}
