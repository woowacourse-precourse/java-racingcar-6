package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCar;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        List<String> racingCars = inputView.readRacingCars();
        int totalRounds = inputView.readAttemptsNumber();

    }
}
