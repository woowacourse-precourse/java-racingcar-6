package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingMachine;
import racingcar.view.InputView;

public class RacingCarController {

    private final NumberGenerator numberGenerator;

    public RacingCarController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    private RacingMachine setting() {
        Cars cars = generateCar();
        int tryCount = InputView.readTryCount();
        return new RacingMachine(cars, tryCount);
    }

    private Cars generateCar() {
        List<String> cars = InputView.readCarNames();
        return Cars.from(cars);
    }
}
