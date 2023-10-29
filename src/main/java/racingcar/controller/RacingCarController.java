package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameCount;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private Race race;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Cars cars = createCarsFromCarNames(inputView.askCarNames());
        GameCount gameCount = GameCount.from(inputView.askGameCount());
    }

    private Cars createCarsFromCarNames(String[] input) {
        List<Car> carList = Arrays.stream(input).map(Car::from).toList();
        return Cars.from(carList);
    }
}
