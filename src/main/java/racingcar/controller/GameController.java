package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarsGenerator;
import racingcar.view.InputView;

public class GameController {

    private final CarsGenerator carsGenerator;

    public GameController(CarsGenerator carsGenerator) {
        this.carsGenerator = carsGenerator;
    }

    private List<Car> generateCars() {
        final String carNames = InputView.inputCarNames();
        return carsGenerator.generate(carNames);
    }

}
