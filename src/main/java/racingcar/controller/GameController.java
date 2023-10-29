package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.util.InputParser;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Cars cars;
    private TryCount tryCount;
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public void playGame() {
        initializeGame();
        startRace();
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

    private void startRace() {
        outputView.printStartResult();
        while (raceContinues()) {
            moveCarsAndPrintStatus();
        }
    }

    private boolean raceContinues() {
        return tryCount.hasRepeat();
    }

    private void moveCarsAndPrintStatus() {
        cars.moveAll(numberGenerator);
        Map<String, Integer> racingStatus = getRacingStatus(cars);
        outputView.printRacingStatus(racingStatus);
        tryCount.decreaseCount();
    }

    private Map<String, Integer> getRacingStatus(Cars cars) {
        Map<String, Integer> carAndPosition = new HashMap<>();

        for (Car car : cars.getCars()) {
            carAndPosition.put(car.getName(), car.getPosition());
        }
        return carAndPosition;
    }
}
