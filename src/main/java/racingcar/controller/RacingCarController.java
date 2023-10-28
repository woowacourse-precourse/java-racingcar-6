package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RacingCarController {

    private Cars generateCar() {
        List<String> cars = InputView.readCarNames();
        return Cars.from(cars);
    }
}
