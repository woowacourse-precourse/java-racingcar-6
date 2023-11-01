package racingcar.domain.controller;

import racingcar.domain.model.Car;
import racingcar.domain.service.GameService;
import racingcar.domain.view.InputView;
import racingcar.domain.view.OutputView;
import racingcar.global.util.Validator;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private final Validator validator;

    public MainController(InputView inputView, OutputView outputView, GameService gameService, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
        this.validator = validator;
    }

    public void startGame() {
        Car car = readCarsNameAndGetCar();
        int count = readNumberOfAttemptsAndGetCount();
        play(car, count);
        calculateWinner(car);
    }

    private Car readCarsNameAndGetCar() {
        outputView.printCarsName();
        String carsName = inputView.readInputData();
        return validateCarsNameAndGetCar(carsName);
    }

    private int readNumberOfAttemptsAndGetCount() {
        outputView.printNumberOfAttempts();
        String numberOfAttempts = inputView.readInputData();
        return validateNumberOfAttemptsAndGetCount(numberOfAttempts);
    }

    private void play(Car car, int count) {
        outputView.printExecutionResult();
        while (count > 0) {
            gameService.handleCar(car);
            outputView.printExecutionResults(car);
            count--;
        }
    }

    private void calculateWinner(Car car) {
        gameService.calculateWinnerCar(car);
        outputView.printResults(car);
    }

    private Car validateCarsNameAndGetCar(String carsName) {
        validator.validateCarsName(carsName);
        return Car.of(carsName);
    }

    private int validateNumberOfAttemptsAndGetCount(String numberOfAttempts) {
        validator.validateNumberOfAttempts(numberOfAttempts);
        return Integer.parseInt(numberOfAttempts);
    }
}
