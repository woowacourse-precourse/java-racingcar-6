package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final NumberGenerator numberGenerator;

    public RacingCarController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        Cars cars = generateCar();
        int tryCount = InputView.readTryCount();
        OutputView.printPlayResult();
        for (int i = 0; i < tryCount; i++) {
            cars.move(numberGenerator);
            OutputView.printResult(cars);
        }
        OutputView.printWinner(cars);
    }

    private Cars generateCar() {
        List<String> cars = InputView.readCarNames();
        return Cars.from(cars);
    }
}
