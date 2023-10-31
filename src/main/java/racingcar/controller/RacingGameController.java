package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.Converter;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Cars cars = new Cars();
    private int attemptNumber;

    public void run() {
        initialize();
        start();
        findWinner();
    }

    private void initialize() {
        List<String> carNames = makeCarNames();

        for (String name : carNames) {
            cars.addCar(new Car(name));
        }

        attemptNumber = makeAttemptNumber();
    }

    private List<String> makeCarNames() {
        String inputNames = inputView.inputNames();
        List<String> carNames = Converter.getCarNames(inputNames);
        InputValidator.validateCarNames(carNames);

        return carNames;
    }

    private int makeAttemptNumber() {
        String inputNumber = inputView.inputAttemptNumber();
        InputValidator.validateAttemptNumber(inputNumber);

        return Integer.parseInt(inputNumber);
    }

    private void start() {
        outputView.showResult();

        int currentAttempt = 1;
        while (isContinue(currentAttempt)) {
            cars.move();
            outputView.showPosition(cars.getCars());
            currentAttempt++;
        }
    }

    private boolean isContinue(int currentAttempt) {
        return currentAttempt <= attemptNumber;
    }

    private void findWinner() {
        List<String> winner = cars.getWinner();
        outputView.showWinner(winner);
    }
}
