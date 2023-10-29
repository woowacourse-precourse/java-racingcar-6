package racingcar.controller;

import java.util.Arrays;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.util.NameSplitter;
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
        Cars cars = createCars(inputCarNames());
        inputGameCount();
    }

    private String[] inputCarNames() {
        return NameSplitter.split(inputView.askCarNames());
    }

    private Cars createCars(String[] carNames) {
        return Cars.from(Arrays.stream(carNames).map(Car::from).toList());
    }

    private void inputGameCount() {
        race.setGameCount(Integer.parseInt(inputView.askGameCount()));
    }
}
