package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.constants.ExceptionMessages;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.util.InputParser;
import racingcar.util.InputValidator;
import racingcar.util.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private TryCount tryCount;
    private final NumberGenerator numberGenerator;

    public GameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void playGame() {
        initializeGame();
        startRace();
        endGame();
    }

    private void initializeGame() {
        outputView.requestCarNames();
        cars = createCars(inputView.inputCars());
        initializeTryCount();
    }

    private void initializeTryCount() {
        outputView.requestTryCount();
        String input = inputView.inputTryCount();
        if (isInvalidInput(input)) {
            ExceptionMessages.INVALID_INPUT_ERROR_MESSAGE.throwException();
        }
        tryCount = createTryCount(input);
    }

    private boolean isInvalidInput(String input) {
        return !InputValidator.isValidInteger(input);
    }

    private Cars createCars(String carNames) {
        List<Car> carList = InputParser.carsSplit(carNames);
        return new Cars(carList);
    }

    private TryCount createTryCount(String tryCountInput) {
        int parsedTryCount = InputParser.tryCountParser(tryCountInput);
        return new TryCount(parsedTryCount);
    }

    private void startRace() {
        outputView.printStartResult();
        while (isRaceOngoing()) {
            moveCarsAndPrintStatus();
        }
    }

    private boolean isRaceOngoing() {
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
