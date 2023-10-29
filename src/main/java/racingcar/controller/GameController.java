package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Cars cars;
    private TryCount tryCount;

    public void playGame() {
        initializeGame();
    }

    private void initializeGame() {
        outputView.requestCarNames();
        cars = generateCars();
        outputView.requestTryCount();
        tryCount = generateTryCount();
    }

    private Cars generateCars() {
        final String carName = inputView.inputCars();
        final List<Car> cars = InputParser.carsSplit(carName);
        return new Cars(cars);
    }

    private TryCount generateTryCount() {
        final String input = inputView.inputTryCount();
        final int tryCount = InputParser.tryCountParser(input);
        return new TryCount(tryCount);
    }
}
