package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameData;
import racingcar.domain.TryCount;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void playGame() {
        outputView.requestCarNames();
        final Cars cars = generateCars();
        outputView.requestTryCount();
        final TryCount tryCount = generateTryCount();
        GameData gameData = initializeGameData(cars, tryCount);
    }

    private GameData initializeGameData(final Cars cars, final TryCount tryCount) {
        return new GameData(cars, tryCount);
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
