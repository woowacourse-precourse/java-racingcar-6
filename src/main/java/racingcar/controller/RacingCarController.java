package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.view.InputView;

public class RacingCarController {

    private final NumberGenerator numberGenerator;

    public RacingCarController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    private Cars generateCar() {
        List<String> cars = InputView.readCarNames();
        return Cars.from(cars);
    }
}
