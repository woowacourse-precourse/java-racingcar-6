package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.constants.ExceptionMessages;
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
        endGame();
    }

    private void initializeGame() {
        outputView.requestCarNames();
        cars = generateCars(inputView.inputCars());
        initializeTryCount();
    }

    private void initializeTryCount() {
        outputView.requestTryCount();
        try {
            tryCount = generateTryCount(inputView.inputTryCount());
        } catch (NumberFormatException e) {
            ExceptionMessages.INVALID_INPUT_ERROR_MESSAGE.throwException();
        }
    }

    private Cars generateCars(String carNames) {
        List<Car> carNameList = InputParser.carsSplit(carNames);
        return new Cars(carNameList);
    }

    private TryCount generateTryCount(String tryCountInput) throws NumberFormatException {
        int parsedTryCount = InputParser.tryCountParser(tryCountInput);
        return new TryCount(parsedTryCount);
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
        Map<String, Integer> racingStatus = cars.getRacingStatus();
        outputView.printRacingStatus(racingStatus);
        tryCount.decreaseCount();
    }

    private void endGame() {
        List<String> topRacers = cars.getTopRacers();
        outputView.printResult(String.join(", ", topRacers));
    }
}
