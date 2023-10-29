package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.RacingView;

public class RacingController {

    private final RacingView view;

    public RacingController(RacingView view) {
        this.view = view;
    }

    public void run() {
        List<Car> cars = view.inputCarNames();
        view.inputTryCount();
    }
}
