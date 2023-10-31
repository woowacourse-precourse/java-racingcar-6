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
        cars = generateCars(inputView.inputCars());
        initializeTryCount();
    }

    private void initializeTryCount() {
        outputView.requestTryCount();
        String input = inputView.inputTryCount();
        if (isInputInvalid(input)) {
            ExceptionMessages.INVALID_INPUT_ERROR_MESSAGE.throwException();
        }
        tryCount = generateTryCount(input);
    }

    private boolean isInputInvalid(String input) {
        return !InputValidator.isInteger(input);
    }

    private Cars generateCars(String carNames) {
        List<Car> carNameList = InputParser.carsSplit(carNames);
        return new Cars(carNameList);
    }

    private TryCount generateTryCount(String tryCountInput) {
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
