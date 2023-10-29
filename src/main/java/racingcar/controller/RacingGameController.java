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
        String inputNames = inputView.inputNames();
        List<String> carNames = Converter.getCarNames(inputNames);
        InputValidator.validateCarNames(carNames);
        for (String name : carNames) {
            cars.addCar(new Car(name));
        }

        String inputNumber = inputView.inputAttemptNumber();
        if (InputValidator.validateAttemptNumber(inputNumber)) {
            attemptNumber = Integer.parseInt(inputNumber);
        }
    }

    private void start() {
        outputView.showResult();

        int currentAttempt = 0;
        while (currentAttempt < attemptNumber) {
            cars.move();
            outputView.showPosition(cars);
            currentAttempt++;
        }

    }

    private void findWinner() {
        List<String> winner = cars.getWinner();
        outputView.showWinner(winner);
    }
}
